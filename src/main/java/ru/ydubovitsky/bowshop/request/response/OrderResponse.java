package ru.ydubovitsky.bowshop.request.response;

import lombok.*;
import ru.ydubovitsky.bowshop.entity.Order;

@Builder
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Order order;

}
