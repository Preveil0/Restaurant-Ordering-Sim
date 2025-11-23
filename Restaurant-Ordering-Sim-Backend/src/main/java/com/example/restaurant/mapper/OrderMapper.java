package com.example.restaurant.mapper;

import com.example.restaurant.dto.order.OrderResponseDto;
// import com.example.restaurant.dto.orderitem.OrderItemResponseDto;
import com.example.restaurant.entity.Order;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();

        dto.setOrder_id(order.getOrder_id());
        dto.setOrder_date(order.getOrder_date());
        dto.setTotal_amount(order.getTotal_amount());

        dto.setItems(
                order.getItems()
                        .stream()
                        .map(OrderItemMapper::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
