package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookModel;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    public AddressBookModel getContactById(long id) {
        return new AddressBookModel(id, "Sparsh", "9999999999",
                "sparsh@test.com", "123 Main St", "Delhi");
    }

    public AddressBookModel addContact(AddressBookDTO dto) {
        return new AddressBookModel(1, dto.getName(), dto.getPhone(),
                dto.getEmail(), dto.getAddress(), dto.getCity());
    }

    public AddressBookModel updateContact(long id, AddressBookDTO dto) {
        return new AddressBookModel(id, dto.getName(), dto.getPhone(),
                dto.getEmail(), dto.getAddress(), dto.getCity());
    }
}