package za.ac.cput.repository;

/**
 * Category.java
 * Category model class
 * Author: Aristide Izabkora (220345821)
 * Date: 25 March 2025
 */

import za.ac.cput.domain.Category;

import java.util.Set;

public interface ICategoryRepository {
    Category create(Category category);
    Category read(String cateId);
    Category update(Category category);
    boolean delete(String cateId);
    Set<Category> getAll();
}
