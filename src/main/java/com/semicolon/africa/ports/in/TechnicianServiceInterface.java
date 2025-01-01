package com.semicolon.africa.ports.in;


import com.semicolon.africa.ports.in.dtos.request.*;
import com.semicolon.africa.ports.in.dtos.request.technician.AvailabilityStatusRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.LoginTechnicianRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.LogoutTechnicianRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.RegisterTechnicianRequest;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.technician.AvailabilityStatusResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.LoginTechnicianResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.LogoutTechnicianResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.RegisterTechnicianResponse;
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
