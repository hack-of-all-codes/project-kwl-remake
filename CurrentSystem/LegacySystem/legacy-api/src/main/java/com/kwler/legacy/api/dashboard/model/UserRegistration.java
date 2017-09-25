package com.kwler.legacy.api.dashboard.model;

import com.kwler.legacy.api.masterdata.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userRegistrationV2")
public class UserRegistration {

    @Id
    String id;

    Country country;
    StandardUser.UserAccount.Type accountType;
    Long date;
    String userId;
    String email;
    String name;
    String subscriptionType;
    String customerId;
    String customerName;
}
