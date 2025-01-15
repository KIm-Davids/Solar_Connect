package com.semicolon.africa.ports.in.dtos.request.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostRequest {

    private long id;
    private String title;
    private String content;

}
