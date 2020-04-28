package com.naranov.contacts.controller;

import com.naranov.contacts.exception.EntityNotFoundException;
import com.naranov.contacts.exception.EntityAlreadyExistsException;
import com.naranov.contacts.model.Person;
import com.naranov.contacts.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // create Person
    @PostMapping
    public Person createPerson(@Valid @RequestBody Person newPerson) throws EntityAlreadyExistsException {
        return personService.createPerson(newPerson);
    }

    // get all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // get person by id
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId) throws EntityNotFoundException {
        return ResponseEntity.ok().body(personService.getPersonById(personId));
    }

    // get all persons by matching (firstName, secondName, middleName)
    @GetMapping("/match/{match}")
    public ResponseEntity<List<Person>> findAllPersonsByMatching(@PathVariable(value="match") String match) throws EntityNotFoundException {
        return ResponseEntity.ok().body(personService.findAllPersonsByMatching(match));
        // доделать если не найден пользователь с таким паттерном
    }

    // modify person by id
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails) throws EntityNotFoundException {
        return ResponseEntity.ok(personService.updatePerson(personId, personDetails));
    }
}
