package com.semicolon.africa.ports.in.dtos.request;

import com.semicolon.africa.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCustomerRequest extends User {

    private long customerId;

}
