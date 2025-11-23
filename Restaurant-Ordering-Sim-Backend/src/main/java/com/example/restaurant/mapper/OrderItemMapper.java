package com.example.restaurant.mapper;

import com.example.restaurant.dto.orderitem.OrderItemResponseDto;
import com.example.restaurant.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItemResponseDto toDto(OrderItem item) {
        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setOrder_items_id(item.getOrder_items_id());
        dto.setQuantity(item.getQuantity());
        dto.setPrice_paid(item.getPrice_paid());

        dto.setMenu_id(item.getMenu().getMenu_id());
        dto.setMenu_name(item.getMenu().getItem_name());

        return dto;
    }
}
