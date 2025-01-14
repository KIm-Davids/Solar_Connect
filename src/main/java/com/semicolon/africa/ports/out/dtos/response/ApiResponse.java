package com.semicolon.africa.ports.out.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private boolean isSuccessful;
    private Object data;
    private String token;

    public ApiResponse(boolean isSuccessful, Object data){
        this.isSuccessful=isSuccessful;
        this.data=data;
    }

    public ApiResponse(boolean isSuccessful, Object data, String token){
        this.isSuccessful=isSuccessful;
        this.data=data;
        this.token=token;
    }
}