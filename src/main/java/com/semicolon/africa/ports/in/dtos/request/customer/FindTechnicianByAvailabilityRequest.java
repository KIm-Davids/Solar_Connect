package com.semicolon.africa.ports.in.dtos.request.customer;

import com.semicolon.africa.domain.constants.Availability;
import com.semicolon.africa.domain.constants.LoginStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindTechnicianByAvailabilityRequest {

    private LoginStatus loginStatus;
    private Availability availability;
}
