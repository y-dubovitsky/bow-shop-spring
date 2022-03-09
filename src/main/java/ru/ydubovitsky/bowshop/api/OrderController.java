package ru.ydubovitsky.bowshop.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.bowshop.dto.OrderDto;
import ru.ydubovitsky.bowshop.entity.Order;
import ru.ydubovitsky.bowshop.mail.EmailServiceImpl;
import ru.ydubovitsky.bowshop.request.response.OrderResponse;
import ru.ydubovitsky.bowshop.service.OrderService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private final EmailServiceImpl emailService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        Order order = orderService.addOrder(orderDto);
        emailService.sendSimpleMessage(
                order.getContacts().getEmail(),
                String.format("Migliori Archi Order %s - accepted!", order.getId()),
                "Hello, your order from Migliori Archi - accepted!"
        );
        return ResponseEntity.ok(OrderResponse
                .builder()
                .order(order)
                .build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value="id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok(id);
    }
}
