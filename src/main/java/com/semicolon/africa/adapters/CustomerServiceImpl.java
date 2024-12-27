package com.semicolon.africa.adapters;

import com.semicolon.africa.adapters.Exceptions.CustomerNotFoundException;
import com.semicolon.africa.domain.Customer;
import com.semicolon.africa.domain.Review;
import com.semicolon.africa.domain.constants.LoginStatus;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.CustomerRepository;
import com.semicolon.africa.ports.out.ReviewRepository;
import com.semicolon.africa.ports.out.dtos.response.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerId(customer.getCustomerId());
        customer.setEmail(customerRequest.getEmail());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setNin(customerRequest.getNin());
        customer.setLocation(customerRequest.getLocation());
        customer.setPassword(customerRequest.getPassword());
        customer.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.OFFLINE.toString()));
        System.out.println(customer);
        customerRepository.save(customer);
        RegisterCustomerResponse response = new RegisterCustomerResponse();
        response.setMessage("Registered Customer Successfully !!!");
        return response;
    }

    @Override
    public CustomerLoginResponse loginCustomer(LoginCustomerRequest customerRequest) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerRequest.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer not found\nPlease try again !!!"));
        if (customer.getIsLoggedIn() == LoginStatus.OFFLINE) {
            customer.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.ONLINE.toString()));
            customerRepository.save(customer);
            CustomerLoginResponse response = new CustomerLoginResponse();
            response.setMessage("Customer Logged In Successfully !!!");
            return response;
        }
        throw new CustomerNotFoundException("Invalid Entry\nPlease try again !!!");
    }

    @Override
    public CustomerLogoutResponse logoutCustomer(LogoutCustomerRequest customerRequest) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerRequest.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer not found\nPlease try again !!!"));
        if (customer.getIsLoggedIn() == LoginStatus.ONLINE) {
            customer.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.OFFLINE.toString()));
            customerRepository.save(customer);
            CustomerLogoutResponse response = new CustomerLogoutResponse();
            response.setMessage("Customer Logged In Successfully !!!");
            return response;
        }
        throw new CustomerNotFoundException("Invalid Entry\nPlease try again !!!");

    }
//
//    @Override
//    public void findTechnicianByRating(RatingFindTechnicianRequest customerRequest) {
//
//    }
//
//    @Override
//    public void findTechnicianByLocation(LocationFindTechnicianRequest customerRequest) {
//
//    }

    @Override
    public CreateReviewResponse createReview(CreateReviewRequest customerRequest) {
        Review review = new Review();
        review.setReviewId(customerRequest.getReviewId());
        review.setReviewDate(LocalDate.now());
        review.setDesc(customerRequest.getDesc());
        review.setTechnicianId(customerRequest.getCustomerId());
        review.setCustomerId(customerRequest.getCustomerId());
        review.setReviewCount(customerRequest.getReviewCount());
        System.out.println(review);
        reviewRepository.save(review);
        CreateReviewResponse response = new CreateReviewResponse();
        response.setMessage("Review Created Successfully");
        return response;
    }


//    @Override
//    public void updateReview(UpdateReviewRequest customerRequest) {
//
//    }
}
