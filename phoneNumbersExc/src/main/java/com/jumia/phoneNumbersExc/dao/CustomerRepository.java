package com.jumia.phoneNumbersExc.dao;

import com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO;
import com.jumia.phoneNumbersExc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "select new com.jumia.phoneNumbersExc.dto.CustomerDetailsDTO( c.id, c.name, c.phone) from Customer c")
    List<CustomerDetailsDTO> getAllCustomers();







}
