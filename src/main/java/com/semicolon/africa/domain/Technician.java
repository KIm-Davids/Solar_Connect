package com.semicolon.africa.domain;

import com.semicolon.africa.domain.constants.Availability;
import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import com.semicolon.africa.domain.constants.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Technician extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technicianId;
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    @Enumerated(EnumType.STRING)
    private Availability isAvailable;
}
