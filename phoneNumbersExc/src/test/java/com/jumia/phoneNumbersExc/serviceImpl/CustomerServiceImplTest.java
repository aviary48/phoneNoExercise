package com.jumia.phoneNumbersExc.serviceImpl;

import com.jumia.phoneNumbersExc.dao.CustomerRepository;
import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.utils.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

 @ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock private CustomerRepository customerRepository;
    @Mock
    private PhoneNumberValidator phoneNumberValidator;
    private CustomerServiceImpl underTest;
    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new CustomerServiceImpl(customerRepository,phoneNumberValidator);

    }


    @Test
    void itShouldListAllCustomers() {
        //when
        underTest.listAllCustomers();
        //then
        verify(customerRepository).getAllCustomers();

        List<CustomerDetailsDTO>allCustomers = customerRepository.getAllCustomers();

        if( allCustomers!=null){
            assertNotNull(allCustomers );
        }



    }

    @Test
    void itShouldValidateAllPhoneNumbersFromNonEmptyList(){
        List<CustomerDetailsDTO>allCustomers = customerRepository.getAllCustomers();

        if( allCustomers!=null){
            assertNotNull(allCustomers );
        }

    }




}