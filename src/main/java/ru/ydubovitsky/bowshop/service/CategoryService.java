package ru.ydubovitsky.bowshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.bowshop.dto.CategoryDto;
import ru.ydubovitsky.bowshop.entity.Category;
import ru.ydubovitsky.bowshop.entity.Product;
import ru.ydubovitsky.bowshop.repository.CategoryRepository;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category addCategory(CategoryDto categoryDto) {
        try {
            Category category = Category.builder()
                    .name(categoryDto.getName())
                    .description(categoryDto.getDescription())
                    .imageByte(categoryDto.getImageByte().getBytes())
                    .build();

            Category savedCategory = categoryRepository.save(category);
            log.info(String.format("Category: %s - saved", categoryDto.getName()));
            return savedCategory;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
