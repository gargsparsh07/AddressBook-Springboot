package com.bridgelabz.addressbookspringboot.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
}