package com.belenits.customerinfo.repository;


import com.belenits.customerinfo.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerInfoRepo extends JpaRepository<CustomerInfo, Long> {
    @Query("From CustomerInfo c where c.name=:name")
    public List<CustomerInfo> getCustomerByName(String name);

    @Query(value ="Select * From Customer_Info c where c.active_Status=:status",nativeQuery = true)
    public List<CustomerInfo> getCustomersByStatus(String status);



}
