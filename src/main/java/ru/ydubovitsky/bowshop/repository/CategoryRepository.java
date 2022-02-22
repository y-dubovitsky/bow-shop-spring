package ru.ydubovitsky.bowshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.bowshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

}
