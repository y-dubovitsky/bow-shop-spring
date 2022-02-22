package ru.ydubovitsky.bowshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ydubovitsky.bowshop.entity.Product;

public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<Product, Integer> {

}
