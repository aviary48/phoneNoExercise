package com.jumia.phoneNumbersExc.dto;


import lombok.Data;

//@Data
public class CustomerDetailsDTO {

   private int id;
   private String name;
   private String phone;
   private String countryCode;
   private String  state;
   private String country;



   public CustomerDetailsDTO(int id, String name, String phone) {
      this.id = id;
      this.name = name;
      this.phone = phone;
   }



   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getCountryCode() {
      return countryCode;
   }

   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }


   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }



   @Override
   public String toString() {
      return "CustomerDetailsDTO{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", phone='" + phone + '\'' +
              ", countryCode='" + countryCode + '\'' +
              ", state='" + state + '\'' +
              ", country='" + country + '\'' +
              '}';
   }




}
