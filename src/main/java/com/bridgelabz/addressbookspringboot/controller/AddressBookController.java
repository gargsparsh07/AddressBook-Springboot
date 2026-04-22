package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookModel;
import com.bridgelabz.addressbookspringboot.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>("Get All Contacts", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getById(@PathVariable long id) {
        return new ResponseEntity<>(addressBookService.getContactById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressBookModel> addContact(@RequestBody AddressBookDTO dto) {
        return new ResponseEntity<>(addressBookService.addContact(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateContact(@PathVariable long id,
                                                          @RequestBody AddressBookDTO dto) {
        return new ResponseEntity<>(addressBookService.updateContact(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        return new ResponseEntity<>("Deleted Contact ID: " + id, HttpStatus.OK);
    }
}