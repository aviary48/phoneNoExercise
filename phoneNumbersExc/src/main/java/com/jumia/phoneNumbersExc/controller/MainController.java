package com.jumia.phoneNumbersExc.controller;

import com.jumia.phoneNumbersExc.dto.CountryDTO;
import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class MainController {

    private static final String className = MainController.class.getSimpleName();


    private final CustomerService customerService;

    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }




    @GetMapping("/")
    public String home(Model model){

        List<CountryDTO> countriesList=null;
        List<CustomerDetailsDTO>listOfAllCustomers = null;
        try{

            listOfAllCustomers = customerService.listAllCustomers();
            countriesList = getCountries();

            model.addAttribute("countries", countriesList);
            model.addAttribute("allCustomers", listOfAllCustomers);

        }catch (Exception e){
            log.error("++++"+ className+" Error  in getAllCustomer is: {}",e.getMessage());
        }

        return "index";
    }

    @PostMapping("/search")
    public String getFilteredRecords(@RequestParam("hdnstate")String state, @RequestParam("hdncountrycode")String countryCode, Model model){
        List<CustomerDetailsDTO>listOfAllCustomers = null; List<CountryDTO> countriesList=null;

         String  phoneState=null;

        try{
            listOfAllCustomers = customerService.listAllCustomers();

            if(state.equals("I")) phoneState = "invalid"; else if(state.equals("V")) phoneState="valid";

            String finalPhoneState = phoneState;
            List<CustomerDetailsDTO> filteredList = listOfAllCustomers.stream()
                    .filter(record -> (record.getState()).equals(finalPhoneState) && (record.getCountryCode()).contains(countryCode) )
                    .collect(Collectors.toList());

            countriesList = getCountries();

            model.addAttribute("allCustomers", filteredList);
            model.addAttribute("countries", countriesList);


        }catch (Exception e){
            log.error("+++++ Error in"+className+"getFilteredRecords is : {}",e.getMessage());
        }

       return "index";
    }





    private static List<CountryDTO> getCountries(){
        return List.of(
                new CountryDTO("237", "Cameroon"),
                new CountryDTO("251", "Ethiopia"),
                new CountryDTO("212", "Morocco"),
                new CountryDTO("258", "Mozambique"),
                new CountryDTO("256", "Uganda")

        );
    }










}
