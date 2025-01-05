package com.semicolon.africa.adapters;

import com.semicolon.africa.adapters.Exceptions.CustomerNotFoundException;
import com.semicolon.africa.adapters.Exceptions.InvalidDetailException;
import com.semicolon.africa.adapters.Exceptions.UserNotLoggedInException;
import com.semicolon.africa.adapters.validations.Validations;
import com.semicolon.africa.domain.Customer;
import com.semicolon.africa.domain.Review;
import com.semicolon.africa.domain.Technician;
import com.semicolon.africa.domain.constants.LoginStatus;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.UpdateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.FindTechnicianByAvailabilityRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LogoutCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.CustomerRepository;
import com.semicolon.africa.ports.out.ReviewRepository;
import com.semicolon.africa.ports.out.TechnicianRepositoryInterface;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLogoutResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.UpdateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.FindTechnicianByAvailabilityResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private TechnicianRepositoryInterface technicianRepositoryInterface;

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest customerRequest) {
        Customer customer = new Customer();
        Validations validation = new Validations();
        customer.setCustomerId(customer.getCustomerId());
        if(validation.validateEmail(customerRequest.getEmail())) {
            customer.setEmail(customerRequest.getEmail());
        }else{
            throw new InvalidDetailException("Invalid Details");
        }
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
        if(customerRequest.getCustomerEmail().equals(customer.getEmail()) && customerRequest.getPassword().equals(customer.getPassword())){
            if (customer.getIsLoggedIn() == LoginStatus.OFFLINE) {
                customer.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.ONLINE.toString()));
                customerRepository.save(customer);
                CustomerLoginResponse response = new CustomerLoginResponse();
                response.setMessage("Customer Logged In Successfully !!!");
                return response;
            }
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

    @Override
    public FindTechnicianByAvailabilityResponse findTechnicianByAvailability(FindTechnicianByAvailabilityRequest customerRequest) {
        if(customerRequest.getLoginStatus().equals(LoginStatus.ONLINE)) {
            List<Technician> technician = technicianRepositoryInterface.findTechnicianByIsAvailable(customerRequest.getAvailability());
            FindTechnicianByAvailabilityResponse response = new FindTechnicianByAvailabilityResponse();
//                response.setFirstName(technician.g  ());
//                response.setLastName(technician.getLastName());
//                response.setPhoneNumber(technician.getPhoneNumber());
//                response.setEmail(technician.getEmail());

                return response;


        }
        throw new UserNotLoggedInException("User not logged in");
    }
//
//    @Override
//    public void findTechnicianByLocation(LocationFindTechnicianRequest customerRequest) {
//
//    }

    @Override
    public CreateReviewResponse createReview(CreateReviewRequest customerRequest) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerRequest.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer not found\nPlease try again !!!"));
        if(customer.getIsLoggedIn().equals(LoginStatus.ONLINE)) {
            Review review = new Review();
            Technician technician = new Technician();
            technician.setTechnicianId(customerRequest.getTechnicianId());
            review.setReviewDate(LocalDate.now());
            review.setDescription(customerRequest.getDescription());
            review.setTechnician(technician);
            review.setCustomerId(customerRequest.getCustomerId());
            review.setRating(customerRequest.getRating());
            reviewRepository.save(review);
            CreateReviewResponse response = new CreateReviewResponse();
            response.setMessage("Review Created Successfully");
            return response;
        }
        throw new UserNotLoggedInException("Customer Not Logged In");

    }


    @Override
    public UpdateReviewResponse updateReview(UpdateReviewRequest customerRequest) {
        Review foundReview = reviewRepository.findReviewByReviewId(customerRequest.getId());
        foundReview.setReviewDate(LocalDate.now());
        foundReview.setReviewCount(customerRequest.getReviewCount());
        foundReview.setDescription(customerRequest.getDescription());
        reviewRepository.save(foundReview);
        UpdateReviewResponse response = new UpdateReviewResponse();
        response.setMessage("Updated Review Successfully");
        return response;
    }
}
