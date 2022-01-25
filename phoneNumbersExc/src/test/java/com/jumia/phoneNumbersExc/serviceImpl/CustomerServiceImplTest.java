package com.jumia.phoneNumbersExc.serviceImpl;

import com.jumia.phoneNumbersExc.dao.CustomerRepository;
import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.mockito.Mockito.verify;

 @ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock private CustomerRepository customerRepository;
    private CustomerServiceImpl underTest;
    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        underTest = new CustomerServiceImpl(customerRepository);
    }



    @Test
    void listAllCustomers() {
        //when
        underTest.listAllCustomers();
        //then
        verify(customerRepository).getAllCustomers();

        //given



        //whern
        underTest.listAllCustomers();




    }


}