package com.example.onetoonedemo.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String streetName;
    private String zipCode;
    private String city;

    @OneToOne
    private Customer customer;
    public Address() {
    }

    public Address(String streetName, String zipCode, String city) {
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
    }
}
