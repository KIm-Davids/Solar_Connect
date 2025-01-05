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

    @PostMapping("/register-technician")
    public ResponseEntity<?> registerTechnician(@RequestBody RegisterTechnicianRequest request){
        try{
            RegisterTechnicianResponse response = technicianService.registerTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/login-technician")
    public ResponseEntity<?> loginTechnician(@RequestBody LoginTechnicianRequest request){
        try{
            LoginTechnicianResponse response = technicianService.loginTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/logout-technician")
    public ResponseEntity<?> logoutTechnician(@RequestBody LogoutTechnicianRequest request){
        try{
            LogoutTechnicianResponse response = technicianService.logoutTechnician(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PutMapping("/change-availability")
    public ResponseEntity<?> changeTechnicianAvailability(@RequestBody AvailabilityStatusRequest request){
        try{
            AvailabilityStatusResponse response = technicianService.changeAvailability(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subscribe-technician")
    public ResponseEntity<?> subscribeTechnician(@RequestBody SubscriptionRequest request){
        try{
            SubscriptionResponse response = technicianService.subscribe(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update-technician-sub")
    public ResponseEntity<?> updateTechnicianSubscription(@RequestBody UpdateSubscriptionRequest request) {
        try {
            SubscriptionResponse response = technicianService.updateSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), INTERNAL_SERVER_ERROR);
        }
    }
}