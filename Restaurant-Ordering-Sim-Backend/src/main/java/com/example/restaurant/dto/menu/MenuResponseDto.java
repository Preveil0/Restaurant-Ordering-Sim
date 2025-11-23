package com.example.restaurant.dto.menu;

import lombok.Data;

@Data
public class MenuResponseDto {

    private Integer menu_id;
    private String item_name;
    private String description;
    private Double price;
    private Integer category_id;
    private String category_name;
}
