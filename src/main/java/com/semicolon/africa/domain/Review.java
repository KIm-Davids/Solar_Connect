package com.semicolon.africa.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Review {

    @Id
    private long reviewId;
    private int reviewCount;
    private String desc;
    private double rating;
    private LocalDate reviewDate;
    private long customerId;
    private long technicianId;

}
