package com.example.PortFolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173") // allow React frontend
@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping("/api/contact")
    public void addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
    }
}
