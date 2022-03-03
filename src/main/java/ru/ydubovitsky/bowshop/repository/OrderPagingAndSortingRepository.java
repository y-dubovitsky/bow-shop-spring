package ru.ydubovitsky.bowshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ydubovitsky.bowshop.entity.Order;

public interface OrderPagingAndSortingRepository extends PagingAndSortingRepository<Order, Long> {
}
