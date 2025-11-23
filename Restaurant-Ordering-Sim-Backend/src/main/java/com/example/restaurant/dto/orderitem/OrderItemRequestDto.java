package com.example.restaurant.dto.orderitem;

import lombok.Data;

@Data
public class OrderItemRequestDto {

    private Integer menu_id;
    private Integer quantity;
}
