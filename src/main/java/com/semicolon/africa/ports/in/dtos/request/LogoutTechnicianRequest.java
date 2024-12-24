package com.semicolon.africa.ports.in.dtos.request;


import com.semicolon.africa.domain.constants.LoginStatus;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutTechnicianRequest {

    @Id
    private Long technicianId;
    private LoginStatus isLoggedIn;


}
