package com.semicolon.africa.ports.in.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReviewRequest {

    private long id;
    private int reviewCount;
    private String description;
}
