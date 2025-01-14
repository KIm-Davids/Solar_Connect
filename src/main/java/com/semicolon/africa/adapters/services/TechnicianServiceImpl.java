package com.semicolon.africa.adapters.services;

import com.semicolon.africa.adapters.Exceptions.*;
import com.semicolon.africa.adapters.validations.Validations;
import com.semicolon.africa.domain.Subscription;
import com.semicolon.africa.domain.Technician;
import com.semicolon.africa.domain.constants.*;
import com.semicolon.africa.ports.in.TechnicianServiceInterface;
import com.semicolon.africa.ports.in.dtos.request.*;
import com.semicolon.africa.ports.in.dtos.request.technician.*;
import com.semicolon.africa.ports.out.SubscriptionRepository;
import com.semicolon.africa.ports.out.TechnicianRepositoryInterface;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.technician.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TechnicianServiceImpl implements TechnicianServiceInterface {

    @Autowired
    private TechnicianRepositoryInterface technicianRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public RegisterTechnicianResponse registerTechnician(RegisterTechnicianRequest request) {
        Technician technician = new Technician();
        Validations validations = new Validations();

//        technician.setTechnicianId(request.getId());
        technician.setFirstName(request.getFirstName());
        technician.setLastName(request.getLastName());
        if(validations.validateEmail(request.getEmail())) {
            technician.setEmail(request.getEmail());
        }else{
            throw new InvalidDetailException("Invalid Details");
        }
        technician.setPassword(request.getPassword());
        if(validations.validatePhoneNumber(request.getPhoneNumber())) {
            technician.setPhoneNumber(request.getPhoneNumber());
        }else{
            throw new InvalidDetailException("Invalid Details");
        }
        technician.setNin(request.getNin());
        technician.setLocation(request.getLocation());
        technician.setUserType(UserType.valueOf(UserType.TECHNICIAN.toString()));
        technician.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.OFFLINE.toString()));
        technician.setIsAvailable(Availability.valueOf(Availability.NOT_AVAILABLE.toString()));
        System.out.println(technician);
        technicianRepository.save(technician);
        RegisterTechnicianResponse response = new RegisterTechnicianResponse();
        response.setMessage("Technician Registered Successfully !!!");
        return response;
    }

    @Override
    public LoginTechnicianResponse loginTechnician(LoginTechnicianRequest loginTechnician) {
        Technician technician = technicianRepository.findByTechnicianId(loginTechnician.getTechnicianId()).orElseThrow(() -> new CannotFIndTechnicianException("Technician Not Found !!!"));
        technician.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.ONLINE.toString()));
        technicianRepository.save(technician);
        LoginTechnicianResponse response = new LoginTechnicianResponse();
        response.setMessage("Logged In Successfully !!!");
        return response;
    }

    @Override
    public LogoutTechnicianResponse logoutTechnician(LogoutTechnicianRequest logoutTechnician) {
        Technician technician = technicianRepository.findByTechnicianId(logoutTechnician.getTechnicianId()).orElseThrow(() -> new CannotFIndTechnicianException("Technician Not Found !!!"));
        technician.setIsLoggedIn(LoginStatus.valueOf(LoginStatus.OFFLINE.toString()));
        technician.setIsAvailable(Availability.NOT_AVAILABLE);
        technicianRepository.save(technician);
        LogoutTechnicianResponse response = new LogoutTechnicianResponse();
        response.setMessage("Logged out Successfully !!!");
        return response;
    }

    @Override
    public AvailabilityStatusResponse changeAvailability(AvailabilityStatusRequest availabilityStatus) {
        Technician technician = technicianRepository.findByTechnicianId(availabilityStatus.getTechnicianId()).orElseThrow(() -> new CannotFIndTechnicianException("Technician Not Found !!!"));
        if(technician.getIsLoggedIn().equals(LoginStatus.ONLINE)) {
            if (availabilityStatus.getIsAvailable().toString().equalsIgnoreCase(Availability.AVAILABLE.toString())) {
                technician.setIsAvailable(Availability.valueOf(Availability.AVAILABLE.toString()));
                technicianRepository.save(technician);
            } else {
                technician.setIsAvailable(Availability.valueOf(Availability.NOT_AVAILABLE.toString()));
                technicianRepository.save(technician);
            }
        }else{
            throw new UserNotLoggedInException("Please Ensure you're Logged In !!!");
        }
        AvailabilityStatusResponse response = new AvailabilityStatusResponse();
        response.setMessage("Changed Availability status successfully");
        return response;
    }

    @Override
    public SubscriptionResponse subscribe(SubscriptionRequest technicianSubscriptionRequest) {
        SubscriptionResponse response = new SubscriptionResponse();
        Technician technician = technicianRepository.findByTechnicianId(technicianSubscriptionRequest.getTechnicianId()).orElseThrow(() -> new CannotFIndTechnicianException("Technician Not Found !!!"));

            if (technician.getIsLoggedIn().equals(LoginStatus.ONLINE)) {
                if(technicianSubscriptionRequest.isPaid()) {
                Subscription subscription = new Subscription();
                subscription.setTechnicianId(technicianSubscriptionRequest.getTechnicianId());
                subscription.setStartDate(technicianSubscriptionRequest.getStartDate());
                subscription.setEndDate(technicianSubscriptionRequest.getEndDate());
                subscription.setSubscriptionStatus(technicianSubscriptionRequest.getSubscriptionStatus());
                subscription.setSubscriptionType(technicianSubscriptionRequest.getSubscriptionType());
                subscriptionRepository.save(subscription);
                response.setMessage("User Subscribed Successfully !!!");
                return response;
            }
        }else{
                throw new UserNotLoggedInException("User not logged in");
            }


        Subscription subscription = subscriptionRepository.findSubscriptionByTechnicianId(technicianSubscriptionRequest.getTechnicianId()).orElseThrow(() -> new SubscriptionDoesNotExistException("Please ensure you have subscribed !!!"));
        if(subscription.getEndDate().equals(LocalDate.now())){
            response.setMessage("Subscription has expired\nWould you like to continue your subscription ?");
            return response;
        }

        throw new TechnicianNotPaidException("Invalid Command !!!");
    }

    @Override
    public SubscriptionResponse updateSubscription(UpdateSubscriptionRequest request){
        Subscription subscription = subscriptionRepository.findSubscriptionByTechnicianId(request.getTechnicianId()).orElseThrow(() ->  new SubscriptionDoesNotExistException("Please ensure you have subscribed !!!"));
        SubscriptionResponse response = new SubscriptionResponse();
            if(subscription.getSubscriptionStatus().equals(SubscriptionStatus.PREMIUM) && request.isPaid()){
            Subscription updatedSubscription = new Subscription();
            updatedSubscription.setTechnicianId(subscription.getTechnicianId());
            updatedSubscription.setSubscriptionType(subscription.getSubscriptionType());
            updatedSubscription.setStartDate(LocalDate.now());
            updatedSubscription.setEndDate(subscription.getEndDate().plusDays(30));
            updatedSubscription.setSubscriptionStatus(subscription.getSubscriptionStatus());
            subscriptionRepository.save(updatedSubscription);
            response.setMessage("User Subscribed Successfully !!!");
            return response;
        }
        throw new TechnicianNotPaidException("Invalid Command !!!");
    }

    @Override
    public TechnicianCertificationResponse setTechnicianCertification(TechnicianCertificationRequest request) {
        Optional<Technician> technician = technicianRepository.findByTechnicianId(request.getId());
        if (request.getIsCertified().equals(CERTIFICATION.CERTIFIED) && technician.isPresent()) {
            technician.get().setCertificationPic(request.getCertificationPic());
            technician.get().setIsCertified(request.getIsCertified().toString());
            technician.get().setTechnicianPic(request.getTechnicianPic());
            technicianRepository.save(technician.get());
            TechnicianCertificationResponse response = new TechnicianCertificationResponse();
            response.setMessage("Technician Certified Successfully");
            return response;
        }
        throw new CannotFIndTechnicianException("User not found");
    }
}
