package com.example.restaurant.dto.order;

import com.example.restaurant.dto.orderitem.OrderItemResponseDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {

    private Integer order_id;
    private LocalDateTime order_date;
    private Double total_amount;

    private List<OrderItemResponseDto> items;
}
