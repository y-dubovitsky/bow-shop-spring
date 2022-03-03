package ru.ydubovitsky.bowshop.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.bowshop.dto.OrderDto;
import ru.ydubovitsky.bowshop.entity.Order;
import ru.ydubovitsky.bowshop.request.response.OrderResponse;
import ru.ydubovitsky.bowshop.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        Order order = orderService.addOrder(orderDto);
        return ResponseEntity.ok(OrderResponse
                .builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .build());
    }

}
