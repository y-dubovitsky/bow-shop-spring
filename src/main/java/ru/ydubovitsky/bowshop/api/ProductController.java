package ru.ydubovitsky.bowshop.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.bowshop.dto.ProductDto;
import ru.ydubovitsky.bowshop.entity.Product;
import ru.ydubovitsky.bowshop.service.ProductService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(path = "/add", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Product> addProduct(@ModelAttribute ProductDto productDto) {
        Product product = productService.addProduct(productDto);
        log.info(String.format("Product %s added", product.getName()));
        return ResponseEntity.ok(product);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        log.info(String.format("Product #%s deleted", id));
        return ResponseEntity.ok(id);
    }

}
