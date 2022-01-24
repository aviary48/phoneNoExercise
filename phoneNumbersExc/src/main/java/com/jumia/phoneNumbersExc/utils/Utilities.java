package com.jumia.phoneNumbersExc.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Utilities {

    private static final String className = Utilities.class.getSimpleName();


    private static final String CAMEROON_PHONE_NUMBER_REGEX = "\\(237\\)\\ ?[2368]\\d{7,8}$";
    private static final String ETHIOPIA_PHONE_NUMBER_REGEX = "\\(251\\)\\ ?[1-59]\\d{8}$";
    private static final String MOROCCO_PHONE_NUMBER_REGEX = "\\(212\\)\\ ?[5-9]\\d{8}$";
    private static final String MOZAMBIQUE_PHONE_NUMBER_REGEX = "\\(258\\)\\ ?[28]\\d{7,8}$";
    private static final String UGANDA_PHONE_NUMBER_REGEX = "\\(256\\)\\ ?\\d{9}$";



    public static String getCountryNameByCountryCode(String phone){

        HashMap<String,String> countryHm = new HashMap<>(); String result=null; String countryCode=null;
        try{
            countryHm.put("237","Cameroon");
            countryHm.put("251","Ethiopia");
            countryHm.put("212","Morocco");
            countryHm.put("258","Mozambique");
            countryHm.put("256","Uganda");

            //  (258) 84330678235

            if( phone != null && !phone.isEmpty()){
                countryCode = phone.substring(1, phone.indexOf(")"));
                result = countryHm.get(countryCode);
            } else{
                throw new Exception("Phone Number Is Empty");
            }

        }catch (Exception e){
          log.error("++++++++++"+className+", Error in getCountryByCountryCode is {} ", e.getMessage());
        }
        return result;
    }

    public static String getCountryCode(String phone){
        String countryCode=null;

        try{
            countryCode = "+" +phone.substring(1,phone.indexOf(")"));

        }catch (Exception e){
            log.error("++++++++++"+className+", Error in getCountryCode is {} ", e.getMessage());
        }

        return countryCode;
    }


    public static String validatePhoneNumber(String phone){

        String result = null;
        String countryCode=null;

        HashMap<String,String> countryHm = new HashMap<>();
        countryHm.put("237","Cameroon");
        countryHm.put("251","Ethiopia");
        countryHm.put("212","Morocco");
        countryHm.put("258","Mozambique");
        countryHm.put("256","Uganda");


        try{

            if(phone!=null && !phone.isEmpty()){

                countryCode = phone.substring(1,phone.indexOf(")"));
                countryCode = countryHm.get(countryCode);

                switch (countryCode){

                    case "Cameroon":
                        try{
                            Pattern pattern = Pattern.compile(CAMEROON_PHONE_NUMBER_REGEX);
                            Matcher matcher = pattern.matcher(phone);
                            if (matcher.matches()) {
                                result = "valid";
                            } else {
                                result = "invalid";
                            }
                        }catch (Exception e){
                            log.error(" +++++++++"+className+" Error in validatePhoneNumber: Cameroon is:  {}",e.getMessage());
                        }
                        break;


                    case "Ethiopia":
                        try {
                            Pattern pattern = Pattern.compile(ETHIOPIA_PHONE_NUMBER_REGEX);
                            Matcher matcher = pattern.matcher(phone);
                            if (matcher.matches()) {
                                result = "valid";
                            } else {
                                result = "invalid";
                            }
                        }catch (Exception e){
                            log.error(" +++++++++"+className+" Error in validatePhoneNumber: Ethiopia is:  {}",e.getMessage());
                        }
                        break;

                    case "Morocco":
                        try{
                            Pattern pattern = Pattern.compile(MOROCCO_PHONE_NUMBER_REGEX);
                            Matcher matcher = pattern.matcher(phone);
                            if (matcher.matches()) {
                                result = "valid";
                            } else {
                                result = "invalid";
                            }
                        }catch (Exception e){
                            log.error(" +++++++++"+className+" Error in validatePhoneNumber: Morocco is:  {}",e.getMessage());
                        }
                        break;


                    case "Mozambique":
                        try{
                            Pattern pattern = Pattern.compile(MOZAMBIQUE_PHONE_NUMBER_REGEX);
                            Matcher matcher = pattern.matcher(phone);
                            if (matcher.matches()) {
                                result = "valid";
                            } else {
                                result = "invalid";
                            }
                        }catch (Exception e){
                            log.error(" +++++++++"+className+" Error in validatePhoneNumber: Mozambique is:  {}",e.getMessage());
                        }
                        break;

                    case "Uganda":
                        try{
                            Pattern pattern = Pattern.compile(UGANDA_PHONE_NUMBER_REGEX);
                            Matcher matcher = pattern.matcher(phone);
                            if (matcher.matches()) {
                                result = "valid";
                            } else {
                                result = "invalid";
                            }
                        }catch (Exception e){
                            log.error(" +++++++++"+className+" Error in validatePhoneNumber: Uganda is:  {}",e.getMessage());
                        }
                        break;
                }

            }else{
                throw new Exception("Phone Number is empty");
            }

        }catch (Exception e){
            log.error(" +++++++++"+className+" Error in validatePhoneNumber is:  {}",e.getMessage());
        }
        return result;
    }



}
