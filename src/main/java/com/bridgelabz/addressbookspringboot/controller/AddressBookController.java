package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>("Get All Contacts", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookModel> getById(@PathVariable long id) {
        AddressBookModel model = new AddressBookModel(id, "Sparsh", "9999999999",
                "sparsh@test.com", "123 Main St", "Delhi");
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressBookModel> addContact(@RequestBody AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(1, dto.getName(), dto.getPhone(),
                dto.getEmail(), dto.getAddress(), dto.getCity());
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookModel> updateContact(@PathVariable long id,
                                                          @RequestBody AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel(id, dto.getName(), dto.getPhone(),
                dto.getEmail(), dto.getAddress(), dto.getCity());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        return new ResponseEntity<>("Deleted Contact ID: " + id, HttpStatus.OK);
    }
}