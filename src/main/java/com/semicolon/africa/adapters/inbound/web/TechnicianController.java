package com.semicolon.africa.adapters.inbound.web;

import com.semicolon.africa.adapters.TechnicianServiceImpl;
import com.semicolon.africa.ports.in.dtos.request.*;
import com.semicolon.africa.ports.out.dtos.response.*;
import org.springframework.beans.factory.annotation.Autowired;
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
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_GATEWAY);
        }
    }

//    @PostMapping("/subscribe_technician")
//    public ResponseEntity<?> subscribeTechnician(@RequestBody SubscriptionRequest request){
//
//    }
}