package ru.ydubovitsky.bowshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"OrderItemTable\"")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer productId;

    private Short count;

    @ManyToOne
    private Order order;

}
