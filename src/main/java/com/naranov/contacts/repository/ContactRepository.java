package com.naranov.contacts.repository;

import com.naranov.contacts.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naranov.contacts.model.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByPersonId(Long personId);
    void deleteAllByPerson(Person person);
}