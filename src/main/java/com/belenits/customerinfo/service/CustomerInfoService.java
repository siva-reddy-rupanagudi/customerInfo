package com.belenits.customerinfo.service;


import com.belenits.customerinfo.entity.CustomerInfo;
import com.belenits.customerinfo.exceptions.CustomerNotFoundException;
import com.belenits.customerinfo.repository.CustomerInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerInfoService {
    @Autowired
    private CustomerInfoRepo customerInfoRepo;

    public CustomerInfo addCustomer(CustomerInfo customerInfo){
        log.info("Customer added to the DataBase Successfully");
      return customerInfoRepo.save(customerInfo);
    }

    public List<CustomerInfo> getAllCustomers() {
        log.info("Fetching all customers from the DataBase");
        return customerInfoRepo.findAll();
    }

    public CustomerInfo getCustomersById(Long id) {
        log.info("Fetching customer by ID: {}", id);
        return customerInfoRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
    }

    public CustomerInfo deleteCustomerById(Long id) {
        log.info("Deleting customer by ID: {}", id);
        CustomerInfo customerInfo = customerInfoRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
        customerInfoRepo.delete(customerInfo);
        return customerInfo;
    }

    public CustomerInfo updateCustomer(CustomerInfo customerInfo) {
        log.info("Updating customer with ID: {}", customerInfo.getId());
        CustomerInfo existingCustomer = customerInfoRepo.findById(customerInfo.getId()).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
        existingCustomer.setName(customerInfo.getName());
        existingCustomer.setEmail(customerInfo.getEmail());
        existingCustomer.setPhone(customerInfo.getPhone());
        log.info("Customer updated successfully with ID: {}", customerInfo.getId());
        return customerInfoRepo.save(existingCustomer);
    }
}
