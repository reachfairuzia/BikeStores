package com.tutorial.bikestores.production.category;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryDbService {
    private final CategoryRepository categoryRepository;
    private final static Integer PAGE_SIZE = 10;
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            categoryDTOList.add(new CategoryDTO(category.getId(), category.getName()));
        }
        return categoryDTOList;
    }

    public void saveCategory(CategoryDTO category) {
        Category cat = new Category(category.getId(), category.getName());
        categoryRepository.save(cat);
    }

    public CategoryDTO getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory
                .orElseThrow(() -> new EntityNotFoundException("tidak di temukan"));
        return new CategoryDTO(category.getId(), category.getName());
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
    public Page<CategoryDTO> getPageCategories(String name, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1, PAGE_SIZE);
        return categoryRepository.findAll(name, pageable);
    }
}
