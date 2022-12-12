package com.example.onetoonedemo;

import com.example.onetoonedemo.ds.Customer;
import com.example.onetoonedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class OneToOneDemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;
    public static void main(String[] args) {
        SpringApplication.run(OneToOneDemoApplication.class, args);
    }

    @Override @Transactional
    public void run(String... args) throws Exception {
        customerService.createDb();

        Customer customer = customerService.findCustomerById(1);
        System.out.println(String.format("%s %s lived in %s",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress().getCity())
        );
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from address");
    }
}
