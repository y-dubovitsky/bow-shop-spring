package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.dto.OrderItemDto;
import ru.ydubovitsky.bowshop.entity.OrderItem;
import ru.ydubovitsky.bowshop.repository.OrderItemRepository;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItem addOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = OrderItem.builder()
                .count(orderItemDto.getCount())
                .productId(orderItemDto.getProductId())
                .build();
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        return savedOrderItem;
    }

}
