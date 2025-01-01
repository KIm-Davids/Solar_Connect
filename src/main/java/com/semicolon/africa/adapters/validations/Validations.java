package com.semicolon.africa.adapters.validations;

import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validations {

    public boolean validateEmail(String request){
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(request);
        return matcher.matches();
    }
    
    public boolean validatePhoneNumber(String request){
        String regex = "^((\\+234)|0)[789][01]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(request);
        return matcher.matches();
    }

}
