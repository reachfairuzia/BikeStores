package com.tutorial.bikestores.production.category;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryStaticService {

    private final static Map<Integer, Category> categories = new HashMap<>();

    static {
        categories.put(1, new Category(1, "Street Bike"));
        categories.put(2, new Category(2, "Mountain Bike"));
        categories.put(3, new Category(3, "Road Bike"));
        categories.put(4, new Category(4, "Family Bike"));
        categories.put(5, new Category(5, "Children Bike"));
        categories.put(6, new Category(6, "Electric Bike"));
    }

    private static int counter = categories.size();

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public void saveCategory(Category category) {
        if (category.getId() == null) {
            category.setId(++counter);
        }
        categories.put(category.getId(), category);
    }

    public CategoryDTO getCategoryById(Integer id) {
        Category category = categories.get(id);
        if(category == null) throw new EntityNotFoundException("Category not found by this ID");
        return new CategoryDTO(category.getId(), category.getName());
    }

    public void deleteCategoryById(Integer id) {
        categories.remove(id);
    }
}
