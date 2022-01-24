package com.jumia.phoneNumbersExc.controller;

import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MainController {

    private static final String className = MainController.class.getSimpleName();


    private final CustomerService customerService;

    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping("/allCustomers")
    public String showCustomerPage(Model model){

        List<CustomerDetailsDTO>listOfAllCustomers = null;
        try{

            listOfAllCustomers = customerService.listAllCustomers();

            model.addAttribute("allCustomer", listOfAllCustomers);

        }catch (Exception e){
            log.error("++++"+ className+" Error  in getAllCustomer is: {}",e.getMessage());
        }

        return "customers";

    }


    @GetMapping("/")
    public String home(Model model){


        List<CustomerDetailsDTO>listOfAllCustomers = null;
        try{

            listOfAllCustomers = customerService.listAllCustomers();

            model.addAttribute("allCustomers", listOfAllCustomers);

        }catch (Exception e){
            log.error("++++"+ className+" Error  in getAllCustomer is: {}",e.getMessage());
        }

        return "index";
    }










}
