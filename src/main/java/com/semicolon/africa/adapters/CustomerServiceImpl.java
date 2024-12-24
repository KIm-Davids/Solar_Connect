package com.semicolon.africa.adapters;

import com.semicolon.africa.domain.Customer;
import com.semicolon.africa.domain.constants.LoginStatus;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.CustomerRepository;
import com.semicolon.africa.ports.out.dtos.response.RegisterCustomerResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;

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
//
//    @Override
//    public void loginCustomer(LoginCustomerRequest customerRequest) {
//
//    }
//
//    @Override
//    public void logoutCustomer(LogoutCustomerRequest customerRequest) {
//
//    }
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
//
//    @Override
//    public void createReview(createReviewRequest customerRequest) {
//
//    }
//
//    @Override
//    public void updateReview(updatetReviewRequest customerRequest) {
//
//    }
}
