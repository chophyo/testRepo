package com.example.onetoonedemo.service;

import com.example.onetoonedemo.dao.AddressDao;
import com.example.onetoonedemo.dao.CustomerDao;
import com.example.onetoonedemo.ds.Address;
import com.example.onetoonedemo.ds.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;

    public Customer findCustomerById(int id){
        return  customerDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Address findAddressById(int id){
        return addressDao.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public void createDb(){
        Customer c1 = new Customer("John", "Doe","john@gmail.com");
        Customer c2 = new Customer("Thomas", "Hardy","thomas@gmail.com");
        Customer c3 = new Customer("John", "William","william@gmail.com");

        Address address1 = new Address("love Lane", "1111", "Yangon");
        Address address2 = new Address("Dream Land", "22222", "Mandalay");
        Address address3 = new Address("Strand Road", "33333", "Yangon");

        c1.setAddress(address1);
        c2.setAddress(address2);
        c3.setAddress(address3);

        addressDao.save(address1);
        addressDao.save(address2);
        addressDao.save(address3);

        customerDao.save(c1);
        customerDao.save(c2);
        customerDao.save(c3);
    }
}
