package com.semicolon.africa.ports.in.dtos.request.technician;

import com.semicolon.africa.domain.constants.CERTIFICATION;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicianCertificationRequest {

    private Long id;
    private String certificationPic;
    private String technicianPic;
    private CERTIFICATION isCertified;
}
