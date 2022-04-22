package ru.ydubovitsky.bowshop.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"ProductTable\"")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String price;

    private String color;

    @ManyToOne
    @NotNull
    private Category category;

    @Column(columnDefinition="TEXT")
    private String description;

    private Short count;

    private byte[] imageByte;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private OrderItem orderItem;

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Date();
    }

    @PrePersist
    protected void prePersist() {
        this.createdAt = new Date();
    }
}
