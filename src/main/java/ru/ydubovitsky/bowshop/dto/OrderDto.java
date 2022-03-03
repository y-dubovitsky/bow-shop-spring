package ru.ydubovitsky.bowshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private List<OrderItemDto> order;

    private ContactsDto contacts;

}
