package ru.ydubovitsky.bowshop.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"CategoryTable\"")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String name;

    private byte[] imageByte;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany
    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageByte=" + Arrays.toString(imageByte) +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
