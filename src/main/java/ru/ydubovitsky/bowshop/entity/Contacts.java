package ru.ydubovitsky.bowshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"ContactsTable\"")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String town;

    private String zipCode;

    private String address;

    private String comment;

    private String country;

    private String email;

    @OneToOne
    private Order order;
}
