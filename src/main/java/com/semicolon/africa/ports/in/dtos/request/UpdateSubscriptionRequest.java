package com.semicolon.africa.ports.in.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSubscriptionRequest {

    private long technicianId;
    private boolean paid;

}
