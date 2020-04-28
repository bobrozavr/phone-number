package com.naranov.contacts.controller;

import com.naranov.contacts.dto.ContactDto;
import com.naranov.contacts.exception.EntityNotFoundException;
import com.naranov.contacts.model.Contact;
import com.naranov.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    // get all the contacts by person id
    @GetMapping("/{id}")
    public ResponseEntity<List<Contact>> getContactByPersonId(@PathVariable(value = "id") Long personId) throws EntityNotFoundException {
        return ResponseEntity.ok().body(contactService.getAllContactsByPersonId(personId));
    }

    // create contact for concrete person id
    @PostMapping
    public ResponseEntity<Contact> createContact(@Valid @RequestBody ContactDto contactDtoDetails)
            throws EntityNotFoundException {
        return ResponseEntity.ok(contactService.createContact(contactDtoDetails));
    }

    // modify concrete contact by contact id
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId, @Valid @RequestBody ContactDto contactDtoDetails) throws EntityNotFoundException {
        return ResponseEntity.ok(contactService.updateContact(contactId, contactDtoDetails));
    }

    // delete concrete contact
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Long contactId)
            throws EntityNotFoundException {
        contactService.delete(contactId);
        Map <String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


