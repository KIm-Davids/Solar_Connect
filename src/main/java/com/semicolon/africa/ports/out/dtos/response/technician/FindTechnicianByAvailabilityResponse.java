package com.semicolon.africa.ports.out.dtos.response.technician;

import com.semicolon.africa.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FindTechnicianByAvailabilityResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String technicianList;

}
