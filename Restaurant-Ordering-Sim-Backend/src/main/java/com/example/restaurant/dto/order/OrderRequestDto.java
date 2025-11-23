package com.example.restaurant.dto.order;

import com.example.restaurant.dto.orderitem.OrderItemRequestDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequestDto {
    private List<OrderItemRequestDto> items;

    public LocalDateTime getOrder_date() {
        return LocalDateTime.now();
        
    }
}
