package com.jumia.phoneNumbersExc.service;

import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDetailsDTO> listAllCustomers() throws Exception;


}
