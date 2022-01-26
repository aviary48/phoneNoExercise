package com.jumia.phoneNumbersExc.dto;

public enum Country {
    MOZAMBIQUE("258"), CAMEROON("237"),ETHIOPIA("251"),MOROCCO("212"),UGANDA("256");

    String countryCode;



    Country(String countryCode){this.countryCode = countryCode;}


    public static String getCountry(String code){

        String country=null;

        switch (code){

            case "258":
                  country = MOZAMBIQUE.toString();
                break;
            case "237":
                  country = CAMEROON.toString();
                break;

            case "251":
                  country = ETHIOPIA.toString();
                break;

            case "212":
                  country = MOROCCO.toString();
                break;
            case "256":
                  country = UGANDA.toString();
                break;

            default:  country = "Invalid Country";
                break;


        }
        return country;

    }

}
