package ru.ydubovitsky.bowshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.bowshop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
