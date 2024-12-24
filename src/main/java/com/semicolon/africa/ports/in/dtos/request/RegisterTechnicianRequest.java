package com.semicolon.africa.ports.in.dtos.request;

import com.semicolon.africa.domain.User;
import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import com.semicolon.africa.domain.constants.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterTechnicianRequest extends User {

    private SubscriptionStatus subscriptionStatus;
    private UserType userType;
    private SubscriptionType subscriptionType;
}
