package com.jumia.phoneNumbersExc.Service;

import com.jumia.phoneNumbersExc.Entity.Customer;

import java.util.List;

public interface PhoneNumbersService {

    List<Customer> getAllCustomers() throws Exception;


}
