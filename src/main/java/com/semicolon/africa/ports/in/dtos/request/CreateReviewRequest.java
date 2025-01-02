package com.semicolon.africa.ports.in.dtos.request;

import com.semicolon.africa.domain.Technician;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReviewRequest {

    private long reviewId;
    private Technician technician;
    private LocalDate reviewDate;
    private String description;
    private long customerId;
    private long technicianId;
    private int rating;
}
