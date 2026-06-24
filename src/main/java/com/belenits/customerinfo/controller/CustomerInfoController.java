package com.belenits.customerinfo.controller;


import com.belenits.customerinfo.dto.CustomerinfoDTO;
import com.belenits.customerinfo.entity.CustomerInfo;
import com.belenits.customerinfo.response.ApiResponse;
import com.belenits.customerinfo.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customersinfo")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;

    //POST /customerinfo/
    @PostMapping("/")
    public ResponseEntity<ApiResponse<CustomerinfoDTO>> addCustomer(@RequestBody CustomerinfoDTO customerinfoDTO) {
        ApiResponse<CustomerinfoDTO> response = new ApiResponse<>();
        response.setStatus(201);
        response.setMessage("Customer added successfully");
        response.setData(customerInfoService.addCustomer(customerinfoDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //GET /customerinfo/all
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CustomerinfoDTO>>> getAllCustomers() {
        List<CustomerinfoDTO> customers = customerInfoService.getAllCustomers();
        ApiResponse<List<CustomerinfoDTO>> reponse = new ApiResponse<>();
        reponse.setStatus(200);
        reponse.setData(customers);
        reponse.setMessage("All customers fetched successfully");
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    //GET /customerinfo/101
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerinfoDTO>> getCustomersById(@PathVariable Long id) {
        ApiResponse<CustomerinfoDTO> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("Customer fetched successfully");
        response.setData(customerInfoService.getCustomersById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // DELETE /customerinfo/101
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerInfo>> deleteCustomerById(@PathVariable Long id) {
        ApiResponse<CustomerInfo> response = new ApiResponse<>();
        response.setData(customerInfoService.deleteCustomerById(id));
        response.setMessage("Customer deleted Sucessfully");
        response.setStatus(200);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // PUT /customerinfo/
    @PutMapping("/")
    public ResponseEntity<ApiResponse<CustomerinfoDTO>> updateCustomerById(@RequestBody CustomerinfoDTO customerinfoDTO) {
        ApiResponse<CustomerinfoDTO> response = new ApiResponse<>();
        response.setStatus(200);
        response.setData(customerInfoService.updateCustomer(customerinfoDTO));
        response.setMessage("Updated the Data of customer," + response.getData());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
