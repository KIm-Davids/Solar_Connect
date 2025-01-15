package com.semicolon.africa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> review;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Post> post;
}
