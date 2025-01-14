package com.semicolon.africa.domain;

import com.semicolon.africa.domain.constants.LoginStatus;
import com.semicolon.africa.domain.constants.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class User {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String location;
    private String nin;
    @Enumerated(EnumType.STRING)
    private LoginStatus isLoggedIn;

}