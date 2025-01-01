package com.semicolon.africa.adapters.inbound.web;

import com.semicolon.africa.adapters.TechnicianServiceImpl;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class TechnicianController {

    private final TechnicianServiceImpl technicianService;

    public TechnicianController(TechnicianServiceImpl technicianService){
        this.technicianService = technicianService;
    }

    @PostMapping("/register_technician")
    public ResponseEntity<?> registerTechnician(@RequestBody RegisterTechnicianRequest request){
        try{
            RegisterTechnicianResponse response = technicianService.registerTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/login_technician")
    public ResponseEntity<?> loginTechnician(@RequestBody LoginTechnicianRequest request){
        try{
            LoginTechnicianResponse response = technicianService.loginTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/logout_technician")
    public ResponseEntity<?> logoutTechnician(@RequestBody LogoutTechnicianRequest request){
        try{
            LogoutTechnicianResponse response = technicianService.logoutTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PutMapping("/change_availability")
    public ResponseEntity<?> changeTechnicianAvailability(@RequestBody AvailabilityStatusRequest request){
        try{
            AvailabilityStatusResponse response = technicianService.changeAvailability(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subscribe_technician")
    public ResponseEntity<?> subscribeTechnician(@RequestBody SubscriptionRequest request){
        try{
            SubscriptionResponse response = technicianService.subscribe(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public ResponseEntity<?> unsubscribeTechnician(@RequestBody UpdateSubscriptionRequest request) {
        try {
            SubscriptionResponse response = technicianService.updateSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }
}