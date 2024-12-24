package com.semicolon.africa.ports.in.dtos.request;

import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SubscriptionRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;
    @Id
    private long technicianId;
    private SubscriptionType subscriptionType;
    private SubscriptionStatus subscriptionStatus;


}
