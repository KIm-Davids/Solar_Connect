package com.semicolon.africa.ports.in.dtos.request.technician;

import com.semicolon.africa.domain.constants.Availability;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailabilityStatusRequest {

    @Id
    private long technicianId;
    private Availability isAvailable;

}
