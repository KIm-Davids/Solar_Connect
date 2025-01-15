package com.semicolon.africa.adapters.inbound.web;

import com.semicolon.africa.adapters.configuration.JWTService;
import com.semicolon.africa.adapters.services.CustomerServiceImpl;
import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.FindTechnicianByAvailabilityRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.ApiResponse;
import com.semicolon.africa.ports.out.dtos.response.CreateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLogoutResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.FindTechnicianByAvailabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = {"http:localhost:8080"})
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private JWTService jwtService;

    @PostMapping("/register-customer")
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterCustomerRequest request){
        try {
            RegisterCustomerResponse response = customerService.registerCustomer(request);
            String token = jwtService.generateToken(request.getEmail(), request.getCustomerId());
            return new ResponseEntity<>(new ApiResponse(true, response, token), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),  HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/login-customer")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginCustomerRequest request){
        try{
            CustomerLoginResponse response = customerService.loginCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/logout-customer")
    public ResponseEntity<?> logoutCustomer(@RequestBody LogoutCustomerRequest request){
        try{
            CustomerLogoutResponse response = customerService.logoutCustomer(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create-review")
    public ResponseEntity<?> createReview(@RequestBody CreateReviewRequest request){
        try{
            CreateReviewResponse response = customerService.createReview(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("search-technician")
    public ResponseEntity<?>  getTechnicianByAvailability(@RequestBody FindTechnicianByAvailabilityRequest request){
        try{
            FindTechnicianByAvailabilityResponse response = customerService.findTechnicianByAvailability(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }

}
