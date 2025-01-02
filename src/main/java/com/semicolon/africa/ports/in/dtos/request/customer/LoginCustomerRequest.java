package com.semicolon.africa.ports.in.dtos.request.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerRequest {

    private long customerId;
    private String customerEmail;
    private String password;
}
