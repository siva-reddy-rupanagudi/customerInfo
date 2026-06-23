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

    @PostMapping("/addCustomer")
    public CustomerInfo addCustomer(@RequestBody CustomerInfo customerInfo){
        return customerInfoService.addCustomer(customerInfo);
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerInfo> getAllCustomers(){
        return customerInfoService.getAllCustomers();
    }
    @GetMapping("/getCustomer/{id}")
    public CustomerInfo getCustomersById(@PathVariable Long id){
        return customerInfoService.getCustomersById(id);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public CustomerInfo deleteCustomerById(@PathVariable Long id){
        return customerInfoService.deleteCustomerById(id);
    }

    @PutMapping("updateCustomer")
    public CustomerInfo updateCustomerById( @RequestBody CustomerInfo customerInfo) {
        return customerInfoService.updateCustomer(customerInfo);
    }

}
