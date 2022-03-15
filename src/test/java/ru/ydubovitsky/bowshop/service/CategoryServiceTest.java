package ru.ydubovitsky.bowshop.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.ydubovitsky.bowshop.dto.CategoryDto;
import ru.ydubovitsky.bowshop.entity.Category;
import ru.ydubovitsky.bowshop.repository.CategoryRepository;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;


class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    private AutoCloseable autoCloseable;
    private CategoryService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategoryService(categoryRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategories() {
        // when
        underTest.getAllCategories();

        // then
        verify(categoryRepository).findAll();
    }

    @Test
    void canGetCategoryByName() {
        // given
        String name = "Diamond";

        // when
        underTest.getCategoryByName(name);

        // then
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(categoryRepository).findByName(argumentCaptor.capture());

        String capturedArg = argumentCaptor.getValue();
        assertThat(capturedArg).isEqualTo(name);
    }

    //TODO Доделать этот тест!
    @Test
    void addCategory() throws IOException {
        // given
        CategoryDto categoryDto = new CategoryDto(
                "Diamond",
                "Some text",
                null
        );
        // when
        underTest.addCategory(categoryDto);

        // then
        ArgumentCaptor<Category> argumentCaptor = ArgumentCaptor.forClass(Category.class);
    }
}