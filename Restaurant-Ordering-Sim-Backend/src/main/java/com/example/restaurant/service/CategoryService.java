package com.example.restaurant.service;

import com.example.restaurant.entity.Category;
import com.example.restaurant.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Integer id, Category updatedCategory) {
        Category category = findById(id);
        category.setCategory_name(updatedCategory.getCategory_name());
        return categoryRepository.save(category);
    }

    private Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
