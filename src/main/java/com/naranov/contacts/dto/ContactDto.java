package com.naranov.contacts.dto;

import lombok.Data;

@Data
public class ContactDto {
    private Long personId;
    private Long contactTypeId;
    private String number;
}
