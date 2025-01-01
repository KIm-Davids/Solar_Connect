package com.semicolon.africa.ports.in.dtos.request.technician;

import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicianSubscriptionRequest {

    private long technicianId;
    private boolean payed;
    private SubscriptionType subscriptionType;
    private SubscriptionStatus subscriptionStatus;

}
