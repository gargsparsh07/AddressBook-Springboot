package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService {

    private List<AddressBookModel> contactList = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(1);

    public List<AddressBookModel> getAllContacts() {
        return contactList;
    }

    public AddressBookModel getContactById(long id) {
        return contactList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(
                idCounter.getAndIncrement(),
                dto.getName(), dto.getPhone(),
                dto.getEmail(), dto.getAddress(), dto.getCity());
        contactList.add(model);
        return model;
    }

    public AddressBookModel updateContact(long id, AddressBookDTO dto) {
        for (AddressBookModel contact : contactList) {
            if (contact.getId() == id) {
                contact.setName(dto.getName());
                contact.setPhone(dto.getPhone());
                contact.setEmail(dto.getEmail());
                contact.setAddress(dto.getAddress());
                contact.setCity(dto.getCity());
                return contact;
            }
        }
        return null;
    }

    public String deleteContact(long id) {
        contactList.removeIf(c -> c.getId() == id);
        return "Deleted Contact ID: " + id;
    }
}