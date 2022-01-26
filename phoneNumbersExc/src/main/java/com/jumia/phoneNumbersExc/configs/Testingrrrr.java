package com.jumia.phoneNumbersExc.configs;

import com.jumia.phoneNumbersExc.dto.Country;

import java.util.Arrays;
import java.util.List;

public class Testingrrrr {


    public static void main(String [] args){


        System.out.println( Country.getCountry("258"));



        List<Country> enumValues = Arrays.asList(Country.values());

        for(Country c: enumValues){
            System.out.println(c);
        }





    }






}
