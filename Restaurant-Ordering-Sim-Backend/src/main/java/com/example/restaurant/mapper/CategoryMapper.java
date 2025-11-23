package com.example.restaurant.mapper;

import com.example.restaurant.dto.category.*;
import com.example.restaurant.entity.Category;

public class CategoryMapper {

    public static CategoryResponseDto toDto(Category c) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategory_id(c.getCategory_id());
        dto.setCategory_name(c.getCategory_name());
        return dto;
    }

    public static Category toEntity(CategoryRequestDto dto) {
        Category c = new Category();
        c.setCategory_name(dto.getCategory_name());
        return c;
    }

    public static CategoryResponseDto toDto(java.util.Locale.Category byId) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }
}
