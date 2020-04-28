package com.naranov.contacts.controller;

import com.naranov.contacts.model.ContactType;
import com.naranov.contacts.service.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/type")
@RequiredArgsConstructor
public class ContactTypeController {

    private final ContactTypeService contactTypeService;

    // get all possible phone types
    @GetMapping
    public List<ContactType> getAllTypes() {
        return contactTypeService.getAllTypes();
    }
}
