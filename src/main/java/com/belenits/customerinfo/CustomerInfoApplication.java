package com.belenits.customerinfo;

import com.belenits.customerinfo.entity.CustomerInfo;
import com.belenits.customerinfo.repository.CustomerInfoRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomerInfoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomerInfoApplication.class, args);
        CustomerInfoRepo customerInfoRepo = context.getBean(CustomerInfoRepo.class);

            LocalDateTime now = LocalDateTime.now();
            List<CustomerInfo> customers = Arrays.asList(
                    new CustomerInfo(null, "Siva", "rsiva@gmail.com", "9988776655", "Hyderabad", now.minusDays(10), "Active"),
                    new CustomerInfo(null, "Asha", "asha@example.com", "9123456780", "Mumbai", now.minusDays(5), "Active"),
                    new CustomerInfo(null, "Rahul", "rahul@example.com", "9012345678", "Delhi", now.minusDays(20), "Inactive"),
                    new CustomerInfo(null, "Priya", "priya@example.com", "9980011223", "Bengaluru", now.minusDays(2), "Active"),
                    new CustomerInfo(null, "Tom", "tom@example.com", "9977665544", "Chennai", now.minusDays(15), "Inactive")
            );

            customerInfoRepo.saveAll(customers);
            customers.forEach(System.out::println);
            List<CustomerInfo> sivaCustomers = customerInfoRepo.getCustomerByName("Siva");
            System.out.println("Customers named Siva:");
            sivaCustomers.forEach(System.out::println);
        System.out.println("Active Customers:");
        List<CustomerInfo> activeCustomers =customerInfoRepo.getCustomersByStatus("Active");
        activeCustomers.forEach(System.out::println);


    }

}
