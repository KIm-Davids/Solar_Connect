package com.semicolon.africa.ports.in.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReviewRequest {

    private long reviewId;
    private long technician;
    private LocalDate reviewDate;
    private String desc;
    private long customerId;
    private long technicianId;
    private int reviewCount;
}
