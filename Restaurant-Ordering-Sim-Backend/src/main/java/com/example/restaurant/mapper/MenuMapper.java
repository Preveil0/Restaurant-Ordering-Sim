package com.example.restaurant.mapper;

import com.example.restaurant.dto.menu.*;
import com.example.restaurant.entity.Menu;
import com.example.restaurant.entity.Category;

public class MenuMapper {

    public static MenuResponseDto toDto(Menu m) {
        MenuResponseDto dto = new MenuResponseDto();

        dto.setMenu_id(m.getMenu_id());
        dto.setItem_name(m.getItem_name());
        dto.setDescription(m.getDescription());
        dto.setPrice(m.getPrice());
       

        if (m.getCategory() != null) {
            dto.setCategory_id(m.getCategory().getCategory_id());
            dto.setCategory_name(m.getCategory().getCategory_name());
        }
        return dto;
    }

    // public static Menu toEntity(MenuRequestDto dto, Category category) {
    //     Menu m = new Menu();
    //     m.setItem_name(dto.getItem_name());
    //     m.setDescription(dto.getDescription());
    //     m.setImage(dto.getImage());
    //     m.setPrice(dto.getPrice());
      
    //     m.setCategory(category);
    //     return m;
    // }

    public static Menu toEntity(MenuRequestDto dto) {
    Menu m = new Menu();
    m.setItem_name(dto.getItem_name());
    m.setDescription(dto.getDescription());
    m.setImage(dto.getImage());
    m.setPrice(dto.getPrice());
    return m;
}

}
