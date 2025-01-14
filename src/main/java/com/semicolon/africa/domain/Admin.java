package com.semicolon.africa.domain;

import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {

    private Long id;
    private SubscriptionStatus subscriptionStatus;
    private UserType userType;

}
