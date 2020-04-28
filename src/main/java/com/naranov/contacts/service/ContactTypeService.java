package com.naranov.contacts.service;

import com.naranov.contacts.model.ContactType;
import com.naranov.contacts.repository.ContactTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactTypeService {
    private final ContactTypeRepository contactTypeRepository;

    public List<ContactType> getAllTypes() {
        return contactTypeRepository.findAll();
    }
}
