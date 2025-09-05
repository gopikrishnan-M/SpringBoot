package com.example.PortFolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }
}
