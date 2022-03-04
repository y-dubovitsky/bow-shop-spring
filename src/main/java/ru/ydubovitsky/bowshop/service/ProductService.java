package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.dto.ProductDto;
import ru.ydubovitsky.bowshop.entity.Category;
import ru.ydubovitsky.bowshop.entity.Product;
import ru.ydubovitsky.bowshop.repository.ProductPagingAndSortingRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductPagingAndSortingRepository productPagingAndSortingRepository;
    private final CategoryService categoryService;

    //TODO Переписать метод
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productPagingAndSortingRepository.findAll().forEach(products::add);

        return products;
    }

    public Product getProductById(Integer productId) {
        Product product = productPagingAndSortingRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException(String.format("Product with id: %s not found", productId)));

        return product;
    }

    public Product addProduct(ProductDto productDto) {
        Category category = categoryService.getCategoryByName(productDto.getCategory());
        try {
            Product product = Product.builder()
                    .name(productDto.getName())
                    .category(category)
                    .color(productDto.getColor())
                    .count(productDto.getCount())
                    .description(productDto.getDescription())
                    .price(productDto.getPrice())
                    .imageByte(productDto.getImageByte().getBytes())
                    .build();
            productPagingAndSortingRepository.save(product);
            log.info(String.format("Product: %s - saved!", product.getName()));
            return product;
        } catch (IOException e) {
            log.error(String.format("Can`t save product with name: %s!", productDto.getName()));
            throw new RuntimeException(e.getMessage());
        }
    }

}
