package com.semicolon.africa.ports.in;

import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLogoutResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest customerRequest);
    CustomerLoginResponse loginCustomer(LoginCustomerRequest customerRequest);
    CustomerLogoutResponse logoutCustomer(LogoutCustomerRequest customerRequest);
//    void findTechnicianByRating(RatingFindTechnicianRequest customerRequest);
//    void findTechnicianByLocation(LocationFindTechnicianRequest customerRequest);
    CreateReviewResponse createReview(CreateReviewRequest customerRequest);
//    void updateReview(UpdateReviewRequest customerRequest);

}
