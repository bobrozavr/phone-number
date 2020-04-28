package com.naranov.contacts.service;

import com.naranov.contacts.dto.ContactDto;
import com.naranov.contacts.exception.EntityNotFoundException;
import com.naranov.contacts.model.Contact;
import com.naranov.contacts.model.ContactType;
import com.naranov.contacts.model.Person;
import com.naranov.contacts.repository.ContactRepository;
import com.naranov.contacts.repository.ContactTypeRepository;
import com.naranov.contacts.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final PersonRepository personRepository;
    private final ContactTypeRepository contactTypeRepository;

    public List<Contact> getAllContactsByPersonId(Long personId) {
        return contactRepository.findAllByPersonId(personId);
    }

    public Contact createContact(ContactDto contactDetails) throws EntityNotFoundException {
        Person person = personRepository.findById(contactDetails.getPersonId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found for this id: " + contactDetails.getPersonId()));

        ContactType contactType = contactTypeRepository.findById(contactDetails.getContactTypeId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found for this id: " + contactDetails.getContactTypeId()));

        Contact contact = new Contact();
        contact.setPerson(person);
        contact.setContactType(contactType);
        contact.setNumber(contactDetails.getNumber());
        return contactRepository.save(contact);
    }


    public Contact updateContact(Long contactId, ContactDto contactDtoDetails) throws EntityNotFoundException {
        Optional<Contact> contactOptional = contactRepository.findById(contactId);

        ContactType contactType = contactTypeRepository.findById(contactDtoDetails.getContactTypeId())
                .orElseThrow(() -> new EntityNotFoundException("ContactType not found for this id: " + contactDtoDetails.getContactTypeId()));

        Person person = personRepository.findById(contactDtoDetails.getPersonId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found for this id: " + contactDtoDetails.getPersonId()));

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            contact.setNumber(contactDtoDetails.getNumber());
            contact.setContactType(contactType);
            contact.setPerson(person);

            return contactRepository.save(contact);
        } else {
            throw new EntityNotFoundException("Contact not found for this id: " + contactId);
        }
    }


    public void delete(Long contactId) throws EntityNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found for this id: " + contactId));

        contactRepository.delete(contact);
    }
}
