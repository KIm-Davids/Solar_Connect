package com.semicolon.africa.ports.in.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewRequest {

    private long reviewId;
    private long technician;
    private String message;
    private long customerId;
    private int reviewCount;
}
