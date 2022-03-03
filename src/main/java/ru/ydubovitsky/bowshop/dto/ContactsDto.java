package ru.ydubovitsky.bowshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactsDto {

    private String firstName;

    private String lastName;

    private String phone;

    private String town;

    private String zipCode;

    private String address;

    private String comment;

    private String country;

    private String email;

}
