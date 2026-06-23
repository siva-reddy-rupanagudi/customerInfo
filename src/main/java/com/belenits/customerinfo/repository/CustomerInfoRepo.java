package com.belenits.customerinfo.repository;


import com.belenits.customerinfo.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepo extends JpaRepository<CustomerInfo, Long> {
}
