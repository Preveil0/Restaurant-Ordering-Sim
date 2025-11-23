package com.example.restaurant.dto.orderitem;

import lombok.Data;

@Data
public class OrderItemResponseDto {

    private Integer order_items_id;
    private Integer quantity;
    private Double price_paid;

    private Integer menu_id;
    private String menu_name;
}
