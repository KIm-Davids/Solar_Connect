package com.semicolon.africa.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Review {

    private int reviewCount;
    private String desc;
    private double rating;
    private Date reviewDate;
    private long technicianId;

}
