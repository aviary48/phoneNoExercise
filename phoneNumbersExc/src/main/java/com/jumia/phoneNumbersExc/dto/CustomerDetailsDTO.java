package com.jumia.phoneNumbersExc.dto;


import lombok.Data;

@Data
public class CustomerDetailsDTO {

   private int id;
   private String name;
   private String phone;
   private Integer countryCode;
   private boolean state;
   private String country;




}
