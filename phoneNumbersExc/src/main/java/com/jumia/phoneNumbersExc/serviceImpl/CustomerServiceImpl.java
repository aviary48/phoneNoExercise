package com.jumia.phoneNumbersExc.serviceImpl;

import com.jumia.phoneNumbersExc.utils.PhoneNumberValidator;
import com.jumia.phoneNumbersExc.utils.Utilities;
import com.jumia.phoneNumbersExc.dao.CustomerRepository;
import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service @Slf4j
public class CustomerServiceImpl implements CustomerService {

    private static final String className = CustomerServiceImpl.class.getSimpleName();

    private final CustomerRepository customerRepository ;




    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public List<CustomerDetailsDTO> listAllCustomers(){

        List<CustomerDetailsDTO>allCustomersList = customerRepository.getAllCustomers();

        try{

            if(allCustomersList != null && !allCustomersList.isEmpty() ){

                allCustomersList.forEach( items -> {

                    items.setState(PhoneNumberValidator.validatePhoneNumber(items.getPhone()));

                    items.setCountry(Utilities.getCountryNameByCountryCode(items.getPhone()));

                    items.setCountryCode(Utilities.getCountryCode(items.getPhone()));

                });

                    log.info("+++++++ the customers are: {}",allCustomersList);

            }

        }catch (Exception e){
          log.error("Error in "+ className+", listAllCustomers is:  {}", e.getMessage());
        }
        return allCustomersList;
    }



}
