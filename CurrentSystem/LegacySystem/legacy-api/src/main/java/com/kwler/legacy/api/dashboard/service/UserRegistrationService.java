package com.kwler.legacy.api.dashboard.service;

import com.kwler.legacy.api.admin.model.Customer;
import com.kwler.legacy.api.dashboard.model.Registration;
import com.kwler.legacy.api.admin.model.StandardUser;
import com.kwler.legacy.api.dashboard.model.UserRegistration;
import com.kwler.legacy.api.admin.repository.CustomerRestRepository;
import com.kwler.legacy.api.admin.repository.StandardUserRestRepository;
import com.kwler.legacy.api.dashboard.repository.UserRegistrationRestRepository;
import com.kwler.legacy.api.security.BCryptPasswordEncoder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@FieldDefaults(makeFinal=true, level= AccessLevel.PRIVATE)
@AllArgsConstructor
@Log
public class UserRegistrationService {

    StandardUserRestRepository standardUserRestRepository;
    UserRegistrationRestRepository userRegistrationRestRepository;
    BCryptPasswordEncoder passwordEncoder;
    CustomerRestRepository customerRestRepository;

    /**
     *
     * @param registration a user registration
     * @return the newly-created user
     */
    public StandardUser register(Registration registration) {
        log.info("registration: " + registration);

        StandardUser user = new StandardUser();

        Customer customer = new Customer();
        customer.setCountry(registration.getCountry().toString());
        customer.setDescription("Free User");

        customer.setName(registration.getFullName());
        customer.setEnrollmentDate(System.currentTimeMillis());
        customer.setSubscriptionType(Customer.SubscriptionType.FREE);
        customerRestRepository.save(customer);

        StandardUser.UserAccount account = new StandardUser.UserAccount();
        account.setRegisterDate(new Date());
        account.setHashedPassword(passwordEncoder.encode(registration.getPassword()));
        account.setRoles(Collections.emptyList());
        account.setType(StandardUser.UserAccount.Type.STANDARD);

        StandardUser.UserProfile profile = new StandardUser.UserProfile();
        profile.setEmail(registration.getEmail().toLowerCase());
        profile.setCountry(registration.getCountry());
        profile.setFullName(registration.getFullName());
        profile.setName(registration.getFullName());
        profile.setCustomerId(customer.getId());
        profile.setNeedsVerification(true);
        profile.setIndustryRole(registration.getIndustryRole());

        user.setUserAccount(account);
        user.setUserProfile(profile);
        standardUserRestRepository.save(user);

        UserRegistration reg = new UserRegistration();
        reg.setUserId(user.getId());
        reg.setSubscriptionType("FREE");
        reg.setDate(System.currentTimeMillis());
        reg.setAccountType(user.getUserAccount().getType());
        reg.setCountry(user.getUserProfile().getCountry());
        reg.setCustomerId(user.getUserProfile().getCustomerId());
        reg.setName(user.getUserProfile().getFullName());
        reg.setEmail(user.getUserProfile().getEmail());
        reg.setCustomerName(registration.getFullName());
        userRegistrationRestRepository.save(reg);

        return user;
    }
}
