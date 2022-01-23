package com.jumia.phoneNumbersExc.Controller;

import com.jumia.phoneNumbersExc.Entity.Customer;
import com.jumia.phoneNumbersExc.Service.PhoneNumbersService;
import com.jumia.phoneNumbersExc.ServiceImpl.PhoneNumbersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class MainController {

    private static final String className = MainController.class.getSimpleName();



    private final PhoneNumbersService phoneNumbersService;

    public MainController(PhoneNumbersService phoneNumbersService) {
        this.phoneNumbersService = phoneNumbersService;
    }



    @GetMapping("/customerslist")
    public String getAllCustomers(Model model){

        List<Customer> customerList=null;
        try{
            customerList = phoneNumbersService.getAllCustomers();

            model.addAttribute("customer", customerList);

        }catch (Exception e){
            log.error("++++"+ className+" Error  in getAllCustomer is: {}",e.getMessage());
        }

        return "customers";

    }










}
