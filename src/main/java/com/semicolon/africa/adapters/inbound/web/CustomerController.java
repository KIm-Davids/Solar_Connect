package com.semicolon.africa.adapters.inbound.web;

import com.semicolon.africa.adapters.CustomerServiceImpl;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.ApiResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLogoutResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterCustomerRequest request){
        try {
            RegisterCustomerResponse response = customerService.registerCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),  HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> loginCustomer(@RequestBody LoginCustomerRequest request){
        try{
            CustomerLoginResponse response = customerService.loginCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> logoutCustomer(@RequestBody LogoutCustomerRequest request){
        try{
            CustomerLogoutResponse response = customerService.logoutCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
