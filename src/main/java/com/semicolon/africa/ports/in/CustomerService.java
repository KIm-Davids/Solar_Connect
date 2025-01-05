package com.semicolon.africa.ports.in;

import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.UpdateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.FindTechnicianByAvailabilityRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLogoutResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.UpdateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.FindTechnicianByAvailabilityResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest customerRequest);
    CustomerLoginResponse loginCustomer(LoginCustomerRequest customerRequest);
    CustomerLogoutResponse logoutCustomer(LogoutCustomerRequest customerRequest);
    FindTechnicianByAvailabilityResponse findTechnicianByAvailability(FindTechnicianByAvailabilityRequest customerRequest);
//    void findTechnicianByLocation(FindTechnicianLocationRequest customerRequest);
    CreateReviewResponse createReview(CreateReviewRequest customerRequest);
    UpdateReviewResponse updateReview(UpdateReviewRequest customerRequest);

}
