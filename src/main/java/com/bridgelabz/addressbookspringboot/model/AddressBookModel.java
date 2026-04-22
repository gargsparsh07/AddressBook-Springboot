package com.bridgelabz.addressbookspringboot.model;

import lombok.Data;

@Data
public class AddressBookModel {
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;

    public AddressBookModel(long id, String name, String phone,
                            String email, String address, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
    }
}