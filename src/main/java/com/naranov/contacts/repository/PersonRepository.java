package com.naranov.contacts.repository;

import com.naranov.contacts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByFirstNameAndLastNameAndMiddleName (String firstName, String lastName, String middleName);
    List<Person> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContaining(String firstName, String lastName, String middleName);

}
