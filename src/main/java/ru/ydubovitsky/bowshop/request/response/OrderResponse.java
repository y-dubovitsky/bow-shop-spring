package ru.ydubovitsky.bowshop.request.response;

import lombok.*;
import ru.ydubovitsky.bowshop.entity.OrderStatus;

@Builder
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;

    private OrderStatus orderStatus;

}
