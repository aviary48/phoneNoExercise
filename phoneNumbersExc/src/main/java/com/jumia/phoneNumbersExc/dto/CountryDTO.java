package com.jumia.phoneNumbersExc.dto;

public class CountryDTO {

    public CountryDTO(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    String countryCode;
    String name;



    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
