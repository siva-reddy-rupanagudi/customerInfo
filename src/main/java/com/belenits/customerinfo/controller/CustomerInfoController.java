package com.belenits.customerinfo.controller;


import com.belenits.customerinfo.entity.CustomerInfo;
import com.belenits.customerinfo.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customersinfo")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;

    //POST /customerinfo/
    @PostMapping("/")
    public CustomerInfo addCustomer(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.addCustomer(customerInfo);
    }

    //GET /customerinfo/all
    @GetMapping("/all")
    public List<CustomerInfo> getAllCustomers() {
        return customerInfoService.getAllCustomers();
    }

    //GET /customerinfo/101
    @GetMapping("/{id}")
    public CustomerInfo getCustomersById(@PathVariable Long id) {
        return customerInfoService.getCustomersById(id);
    }

    // DELETE /customerinfo/101
    @DeleteMapping("/{id}")
    public CustomerInfo deleteCustomerById(@PathVariable Long id) {
        return customerInfoService.deleteCustomerById(id);
    }

    // PUT /customerinfo/
    @PutMapping("/")
    public CustomerInfo updateCustomerById(@RequestBody CustomerInfo customerInfo) {
        return customerInfoService.updateCustomer(customerInfo);
    }

}
