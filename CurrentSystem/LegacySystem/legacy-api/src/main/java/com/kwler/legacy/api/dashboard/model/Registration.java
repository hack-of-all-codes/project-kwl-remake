package com.kwler.legacy.api.dashboard.model;

import com.kwler.legacy.api.masterdata.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    String email;
    String password;
    boolean isTermsAccepted;
    Country country;
    String fullName;
    String industryRole;
}
