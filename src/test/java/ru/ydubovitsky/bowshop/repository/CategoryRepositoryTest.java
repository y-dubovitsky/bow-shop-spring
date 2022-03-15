package ru.ydubovitsky.bowshop.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.ydubovitsky.bowshop.entity.Category;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository underTest;

    @Test
    void itShouldNotNullCategoryByNameIfExists() {
        // given
        String name = "Diamond";
        Category category = Category.builder()
                .name(name)
                .description("Beauty item")
                .build();
        Category save = underTest.save(category);

        // when
        Category byName = underTest.findByName(name);

        // then
        assertThat(byName).isNotNull();
    }
}