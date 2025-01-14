package com.semicolon.africa.adapters.services;

import com.semicolon.africa.domain.Admin;
import com.semicolon.africa.domain.Technician;
import com.semicolon.africa.domain.UserPrincipal;
import com.semicolon.africa.ports.out.TechnicianRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminServices implements UserDetailsService {

   @Autowired
   private TechnicianRepositoryInterface technicianRepositoryInterface;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Technician technician = technicianRepositoryInterface.findTechnicianByEmail(username);
        if(technician == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(technician);
    }
}
