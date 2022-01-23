package com.jumia.phoneNumbersExc.Dao;

import com.jumia.phoneNumbersExc.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "select c from Customer c")
    List<Customer> getAllCustomers();


}
