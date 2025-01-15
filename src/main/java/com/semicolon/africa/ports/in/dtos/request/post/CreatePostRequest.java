package com.semicolon.africa.ports.in.dtos.request.post;

import com.semicolon.africa.domain.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {

    private long id;
    private long customerId;
    private String title;
    private String content;
    private Customer customer;

}
