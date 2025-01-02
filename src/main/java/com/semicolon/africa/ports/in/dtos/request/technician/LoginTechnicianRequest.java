package com.semicolon.africa.ports.in.dtos.request.technician;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginTechnicianRequest {

    @Id
    private Long technicianId;
    private String customerEmail;
    private String password;

}
