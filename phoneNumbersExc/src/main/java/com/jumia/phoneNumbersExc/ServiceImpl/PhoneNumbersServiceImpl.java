package com.jumia.phoneNumbersExc.ServiceImpl;

import com.jumia.phoneNumbersExc.Dao.CustomerRepository;
import com.jumia.phoneNumbersExc.Entity.Customer;
import com.jumia.phoneNumbersExc.Service.PhoneNumbersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class PhoneNumbersServiceImpl implements PhoneNumbersService {

    private static final String className = PhoneNumbersServiceImpl.class.getSimpleName();

    private final CustomerRepository customerRepository;

    public PhoneNumbersServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomers()  {
        List<Customer>arrAllCustomers = null;
        try{
            arrAllCustomers =  customerRepository.getAllCustomers();

            if( arrAllCustomers != null){
                log.info("++++customer list size {} ", arrAllCustomers.size() );

                for(Customer c : arrAllCustomers){
                    log.info("phone: "+ c.phone + " name:" + c.name);
                }

            }
        }catch (Exception e){
            log.error("++++++ Error in getAllCustomers "+ className + " is : {}", e.getMessage());
        }
        return arrAllCustomers;
    }
}
