package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.dto.OrderItemDto;
import ru.ydubovitsky.bowshop.entity.OrderItem;
import ru.ydubovitsky.bowshop.entity.Product;
import ru.ydubovitsky.bowshop.repository.OrderItemRepository;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderItem addOrderItem(OrderItemDto orderItemDto) {
        Product product = productService.getProductById(orderItemDto.getProductId());

        OrderItem orderItem = OrderItem.builder()
                .count(orderItemDto.getCount())
                .product(product)
                .build();
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        return savedOrderItem;
    }

}
