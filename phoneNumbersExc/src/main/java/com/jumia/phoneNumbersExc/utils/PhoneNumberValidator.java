package com.jumia.phoneNumbersExc.utils;

import com.jumia.phoneNumbersExc.dto.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j @Service
public class PhoneNumberValidator {

    private static final String className = PhoneNumberValidator.class.getSimpleName();


    private static final String CAMEROON_PHONE_NUMBER_REGEX = "\\(237\\)\\ ?[2368]\\d{7,8}$";
    private static final String ETHIOPIA_PHONE_NUMBER_REGEX = "\\(251\\)\\ ?[1-59]\\d{8}$";
    private static final String MOROCCO_PHONE_NUMBER_REGEX = "\\(212\\)\\ ?[5-9]\\d{8}$";
    private static final String MOZAMBIQUE_PHONE_NUMBER_REGEX = "\\(258\\)\\ ?[28]\\d{7,8}$";
    private static final String UGANDA_PHONE_NUMBER_REGEX = "\\(256\\)\\ ?\\d{9}$";



    public static String validatePhoneNumber(String phoneNumber) {


        String country = Country.getCountry( phoneNumber.substring(1, phoneNumber.indexOf(")")));

        String result=null;

        try{

            switch (country){

                case "CAMEROON":
                    try{
                        Pattern pattern = Pattern.compile(CAMEROON_PHONE_NUMBER_REGEX);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            result = "valid";
                        } else {
                            result = "invalid";
                        }
                    }catch (Exception e){
                        log.error(" +++++++++"+className+" Error in validatePhoneNumber: Cameroon is:  {}",e.getMessage());
                    }
                    break;


                case "ETHIOPIA":
                    try {
                        Pattern pattern = Pattern.compile(ETHIOPIA_PHONE_NUMBER_REGEX);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            result = "valid";
                        } else {
                            result = "invalid";
                        }
                    }catch (Exception e){
                        log.error(" +++++++++"+className+" Error in validatePhoneNumber: Ethiopia is:  {}",e.getMessage());
                    }
                    break;

                case "MOROCCO":
                    try{
                        Pattern pattern = Pattern.compile(MOROCCO_PHONE_NUMBER_REGEX);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            result = "valid";
                        } else {
                            result = "invalid";
                        }
                    }catch (Exception e){
                        log.error(" +++++++++"+className+" Error in validatePhoneNumber: Morocco is:  {}",e.getMessage());
                    }
                    break;


                case "MOZAMBIQUE":
                    try{
                        Pattern pattern = Pattern.compile(MOZAMBIQUE_PHONE_NUMBER_REGEX);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            result = "valid";
                        } else {
                            result = "invalid";
                        }
                    }catch (Exception e){
                        log.error(" +++++++++"+className+" Error in validatePhoneNumber: Mozambique is:  {}",e.getMessage());
                    }
                    break;

                case "UGANDA":
                    try{
                        Pattern pattern = Pattern.compile(UGANDA_PHONE_NUMBER_REGEX);
                        Matcher matcher = pattern.matcher(phoneNumber);
                        if (matcher.matches()) {
                            result = "valid";
                        } else {
                            result = "invalid";
                        }
                    }catch (Exception e){
                        log.error(" +++++++++"+className+" Error in validatePhoneNumber: Uganda is:  {}",e.getMessage());
                    }
                    break;

                default: result ="no match";

            }



        }catch (Exception e){
            log.error("+++++++ Error is {}",e.getMessage());
        }


        return result;
    }






}
