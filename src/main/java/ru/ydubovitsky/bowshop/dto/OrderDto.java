package ru.ydubovitsky.bowshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ydubovitsky.bowshop.entity.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private List<OrderItemDto> order;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private ContactsDto contacts;

}
