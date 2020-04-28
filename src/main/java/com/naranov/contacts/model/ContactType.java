package com.naranov.contacts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ContactType")
@Table(name = "contact_type")
@Getter
@Setter
@EqualsAndHashCode
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeNumber typeNumber;
}
