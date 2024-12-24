package com.semicolon.africa.ports.in;

import com.semicolon.africa.ports.in.dtos.request.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.RegisterCustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest customerRequest);
//    void loginCustomer(LoginCustomerRequest customerRequest);
//    void logoutCustomer(LogoutCustomerRequest customerRequest);
//    void findTechnicianByRating(RatingFindTechnicianRequest customerRequest);
//    void findTechnicianByLocation(LocationFindTechnicianRequest customerRequest);
//    void createReview(createReviewRequest customerRequest);
//    void updateReview(updatetReviewRequest customerRequest);

}
