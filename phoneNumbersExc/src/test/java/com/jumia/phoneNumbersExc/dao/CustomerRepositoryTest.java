package com.jumia.phoneNumbersExc.dao;

import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.utils.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;



    @Test
    void itShouldGetAllCustomers() {

        List<CustomerDetailsDTO> allCustomers = underTest.getAllCustomers();
        assertNotNull(allCustomers);

    }
}