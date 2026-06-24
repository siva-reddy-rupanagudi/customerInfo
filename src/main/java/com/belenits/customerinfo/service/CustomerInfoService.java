package com.belenits.customerinfo.service;


import com.belenits.customerinfo.dto.CustomerinfoDTO;
import com.belenits.customerinfo.entity.CustomerInfo;
import com.belenits.customerinfo.exceptions.CustomerNotFoundException;
import com.belenits.customerinfo.repository.CustomerInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerInfoService {
    @Autowired
    private CustomerInfoRepo customerInfoRepo;

    public CustomerinfoDTO addCustomer(CustomerinfoDTO customerinfoDTO) {
        log.info("Customer added to the DataBase Successfully");
        CustomerInfo customerInfo = new CustomerInfo();
        BeanUtils.copyProperties(customerinfoDTO, customerInfo);
        BeanUtils.copyProperties(customerInfoRepo.save(customerInfo), customerinfoDTO);
        return customerinfoDTO;
    }

    public List<CustomerinfoDTO> getAllCustomers() {
        log.info("Fetching all Active customers from the DataBase");
        List<CustomerInfo> customerInfos = customerInfoRepo.findAll().stream().filter(cus -> cus.getActiveStatus().equalsIgnoreCase("YES")).toList();
        List<CustomerinfoDTO> dtos = new ArrayList<>();
        for (CustomerInfo customerInfo : customerInfos) {
            CustomerinfoDTO dto = new CustomerinfoDTO();
            BeanUtils.copyProperties(customerInfo, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public CustomerinfoDTO getCustomersById(Long id) {
        log.info("Fetching customer by ID: {}", id);
        CustomerInfo customerInfo = customerInfoRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        CustomerinfoDTO customerinfoDTO = new CustomerinfoDTO();
        BeanUtils.copyProperties(customerInfo, customerinfoDTO);
        return customerinfoDTO;
    }

    public CustomerInfo deleteCustomerById(Long id) {
        log.info("Deleting customer by ID: {}", id);
        CustomerInfo customerInfo = customerInfoRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        customerInfoRepo.delete(customerInfo);
        return customerInfo;
    }

    public CustomerinfoDTO updateCustomer(CustomerinfoDTO customerinfoDTO) {
        log.info("Updating customer with ID: {}", customerinfoDTO.getId());
        CustomerInfo existingCustomer = customerInfoRepo.findById(customerinfoDTO.getId()).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        existingCustomer.setName(customerinfoDTO.getName());
        existingCustomer.setEmail(customerinfoDTO.getEmail());
        existingCustomer.setPhone(customerinfoDTO.getPhone());
        existingCustomer.setActiveStatus(customerinfoDTO.getActiveStatus());
        log.info("Customer updated successfully with ID: {}", customerinfoDTO.getId());
        BeanUtils.copyProperties(customerInfoRepo.save(existingCustomer), customerinfoDTO);
        return customerinfoDTO;
    }
}
