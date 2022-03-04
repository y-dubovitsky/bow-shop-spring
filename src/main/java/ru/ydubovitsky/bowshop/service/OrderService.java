package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ydubovitsky.bowshop.dto.OrderDto;
import ru.ydubovitsky.bowshop.entity.Contacts;
import ru.ydubovitsky.bowshop.entity.Order;
import ru.ydubovitsky.bowshop.entity.OrderStatus;
import ru.ydubovitsky.bowshop.repository.OrderPagingAndSortingRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    private final OrderPagingAndSortingRepository orderPagingAndSortingRepository;
    private final ContactsService contactsService;
    private final OrderItemService orderItemService;

    @Transactional
    public Order addOrder(OrderDto orderDto) {
        Contacts savedContacts = contactsService.addContacts(orderDto.getContacts());

        Order order = Order.builder()
                .orderItems(orderDto.getOrder().stream()
                        .map(orderItemDto -> orderItemService.addOrderItem(orderItemDto))
                        .collect(Collectors.toList()))
                //FIXME Как то поправить это!
                .orderStatus(OrderStatus.ACCEPTED)
                .build();
        order.setContacts(savedContacts);

        Order savedOrder = orderPagingAndSortingRepository.save(order);
        log.info(String.format("Order with id: %s - saved!", savedOrder.getId()));

        return savedOrder;
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = StreamSupport.stream(
                orderPagingAndSortingRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return orderList;
    }
}
