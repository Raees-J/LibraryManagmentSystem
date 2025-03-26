package za.ac.cput.repository;

/**
 * Category.java
 * Category model class
 * Author: Aristide Izabkora (220345821)
 * Date: 25 March 2025
 */

import za.ac.cput.domain.Category;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CategoryRepository implements ICategoryRepository{
    private static CategoryRepository repository = null;
    private Map<String, Category> cateMap;

    private CategoryRepository() {
        cateMap = new HashMap<>();
    }

    public static CategoryRepository getRepository() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }
    @Override
    public Category create(Category category) {
        cateMap.put(category.getCateId(), category);
        return category;
    }

    @Override
    public Category read(String name) {
        return cateMap.get(name);
    }

    @Override
    public Category update(Category category) {
        if (cateMap.containsKey(category.getCateId())) {
            cateMap.put(category.getCateId(), category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(String cateId) {
        if (cateMap.containsKey(cateId)) {
            cateMap.remove(cateId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Category> getAll() {
        return new HashSet<>(cateMap.values());
    }


}//end
