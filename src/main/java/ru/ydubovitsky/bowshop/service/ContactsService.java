package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.dto.ContactsDto;
import ru.ydubovitsky.bowshop.entity.Contacts;
import ru.ydubovitsky.bowshop.repository.ContactsRepository;

@Service
@AllArgsConstructor
public class ContactsService {

    private final ContactsRepository contactsRepository;

    public Contacts addContacts(ContactsDto contactsDto) {
        Contacts contact = Contacts.builder()
                .address(contactsDto.getAddress())
                .comment(contactsDto.getComment())
                .email(contactsDto.getEmail())
                .firstName(contactsDto.getFirstName())
                .lastName(contactsDto.getLastName())
                .country(contactsDto.getCountry())
                .phone(contactsDto.getPhone())
                .town(contactsDto.getTown())
                .zipCode(contactsDto.getZipCode())
                .build();

        Contacts savedContact = contactsRepository.save(contact);
        return savedContact;
    }

}
