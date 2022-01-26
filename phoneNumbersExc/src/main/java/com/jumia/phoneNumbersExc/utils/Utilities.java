package com.jumia.phoneNumbersExc.utils;

import com.jumia.phoneNumbersExc.dto.Country;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Utilities {

    private static final String className = Utilities.class.getSimpleName();

    public static String getCountryNameByCountryCode(String phone) {

        String result=null; String sanitizedPhoneNumber=null;


            sanitizedPhoneNumber = sanitizePhoneNumber(phone);
            if( sanitizedPhoneNumber != null && !sanitizedPhoneNumber.isEmpty()){
                result = Country.getCountry(sanitizedPhoneNumber);
            } else{
                throw new IllegalArgumentException("Phone Number Is Empty");
            }


        return result;
    }

    public static String getCountryCode(String phone) {

        if(sanitizePhoneNumber(phone) != null)
        return "+"+sanitizePhoneNumber(phone);
        else
            throw new IllegalArgumentException();
    }

    static String  sanitizePhoneNumber(String phone){
        if(phone!=null && !phone.isEmpty()) {
            if(phone.startsWith("(")) {
                return phone.substring(1, phone.indexOf(")"));
            }else{
                throw new IllegalArgumentException();
            }
        }
        return null;
    }




}
