package com.semicolon.africa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewCount=" + reviewCount +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", reviewDate=" + reviewDate +
                ", customerId=" + customerId +
                ", technicianId=" + technicianId +
                '}';
    }

    private LocalDate reviewDate;
    private long customerId;
    private long technicianId;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "technician")
    private Technician technician;


}
