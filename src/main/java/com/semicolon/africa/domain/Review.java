package com.semicolon.africa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private int reviewCount;
    private String description;
    private double rating;
    private LocalDate reviewDate;
    private long customerId;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

}
