package ru.ydubovitsky.bowshop.api;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.bowshop.dto.CategoryDto;
import ru.ydubovitsky.bowshop.entity.Category;
import ru.ydubovitsky.bowshop.service.CategoryService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @RequestMapping(path = "/add", method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Category> addCategory(CategoryDto categoryDto) {
        Category category = categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(category);
    }

}
