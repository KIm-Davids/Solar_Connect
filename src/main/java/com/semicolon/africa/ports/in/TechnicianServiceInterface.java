package com.semicolon.africa.ports.in;


import com.semicolon.africa.ports.in.dtos.request.*;
import com.semicolon.africa.ports.out.dtos.response.*;
import org.springframework.stereotype.Service;

@Service
public interface TechnicianServiceInterface {

    RegisterTechnicianResponse registerTechnician(RegisterTechnicianRequest registerTechnician);
    LoginTechnicianResponse loginTechnician(LoginTechnicianRequest loginTechnician);
    LogoutTechnicianResponse logoutTechnician(LogoutTechnicianRequest logoutTechnician);
    AvailabilityStatusResponse changeAvailability(AvailabilityStatusRequest availabilityStatus);
    SubscriptionResponse subscribe(SubscriptionRequest technicianSubscriptionRequest);
    SubscriptionResponse updateSubscription(UpdateSubscriptionRequest request);
}
