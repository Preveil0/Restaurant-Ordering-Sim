package com.example.restaurant.dto.menu;

import lombok.Data;

@Data
public class MenuRequestDto {

    private Integer category_id;
    private String item_name;
    private String description;
    private byte[] image;
    private Double price;
}
