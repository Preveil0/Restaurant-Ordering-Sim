package com.example.restaurant.controller;

import com.example.restaurant.dto.category.CategoryRequestDto;
import com.example.restaurant.dto.category.CategoryResponseDto;
import com.example.restaurant.mapper.CategoryMapper;
import com.example.restaurant.entity.Category;
import com.example.restaurant.service.CategoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET all
    @GetMapping
    public List<CategoryResponseDto> getAll() {
        return categoryService.getAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    // GET by id
    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Integer id) {
        return CategoryMapper.toDto(categoryService.getById(id));
    }

    // CREATE
    @PostMapping
    public CategoryResponseDto create(@RequestBody CategoryRequestDto dto) {
        Category category = CategoryMapper.toEntity(dto);
        return CategoryMapper.toDto(categoryService.save(category));
    }

    // UPDATE
    @PutMapping("/{id}")
    public CategoryResponseDto update(@PathVariable Integer id, @RequestBody CategoryRequestDto dto) {
        Category updated = CategoryMapper.toEntity(dto);
        return CategoryMapper.toDto(categoryService.update(id, updated));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }
}
