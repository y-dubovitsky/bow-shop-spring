package ru.ydubovitsky.bowshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String price;

    private String color;

    @ManyToOne
    private Category category;

    private String description;

    private Short count;

    private byte[] imageByte;

}
