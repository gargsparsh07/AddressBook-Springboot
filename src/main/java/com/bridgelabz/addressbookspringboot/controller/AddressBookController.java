package com.bridgelabz.addressbookspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>("Get All Contacts", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return new ResponseEntity<>("Get Contact by ID: " + id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>("Added Contact: " + body.get("name"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @RequestBody Map<String, String> body) {
        return new ResponseEntity<>("Updated Contact ID: " + id + " Name: " + body.get("name"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return new ResponseEntity<>("Deleted Contact ID: " + id, HttpStatus.OK);
    }
}