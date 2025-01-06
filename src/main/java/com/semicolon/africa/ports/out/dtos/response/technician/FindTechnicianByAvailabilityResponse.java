package com.semicolon.africa.ports.out.dtos.response.technician;

import com.semicolon.africa.domain.Technician;
import com.semicolon.africa.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FindTechnicianByAvailabilityResponse {

   private String technicianList;

}
