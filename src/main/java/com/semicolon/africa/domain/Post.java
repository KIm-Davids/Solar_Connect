package com.semicolon.africa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String title;
    private String content;
    private long customerId;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

}
