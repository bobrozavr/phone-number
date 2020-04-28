package com.naranov.contacts.service;

import com.naranov.contacts.exception.EntityAlreadyExistsException;
import com.naranov.contacts.exception.EntityNotFoundException;
import com.naranov.contacts.model.Contact;
import com.naranov.contacts.model.Person;
import com.naranov.contacts.repository.ContactRepository;
import com.naranov.contacts.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;

    public Person createPerson(Person newPerson) throws EntityAlreadyExistsException {
        Person existingPerson = personRepository.findByFirstNameAndLastNameAndMiddleName(newPerson.getFirstName(), newPerson.getLastName(), newPerson.getMiddleName());
        if (existingPerson != null) {
            throw new EntityAlreadyExistsException("Person already exists with the given first name: " + newPerson.getFirstName() +
                    ", last name: " + newPerson.getLastName() + " and middle name: " + newPerson.getMiddleName());
        } else {
            return personRepository.save(newPerson);
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    public Person getPersonById(Long personId) throws EntityNotFoundException {
        return personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not found for this id: " + personId));
    }

    public List<Person> findAllPersonsByMatching(String match) {
        return personRepository.findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContaining(match, match, match);
    }

    public Person updatePerson(Long personId, Person personDetails) throws EntityNotFoundException {
        Optional<Person> personOptional = personRepository.findById(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setMiddleName(personDetails.getMiddleName());
            person.setPosition(personDetails.getPosition());

            return personRepository.save(person);
        } else {
            throw new EntityNotFoundException("Person not found for this id: " + personId);
        }
    }
}
