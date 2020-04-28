package com.naranov.contacts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Contact")
@Table(name = "contacts")
@Getter
@Setter
@EqualsAndHashCode
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number", nullable = false)
    private String number;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contact_type_id")
    private ContactType contactType;
}
