package com.example.restaurant.controller;

import com.example.restaurant.dto.order.OrderRequestDto;
import com.example.restaurant.dto.order.OrderResponseDto;
import com.example.restaurant.mapper.OrderMapper;
import com.example.restaurant.entity.Order;
import com.example.restaurant.entity.OrderItem;
import com.example.restaurant.entity.Menu;
import com.example.restaurant.service.OrderService;
import com.example.restaurant.service.MenuService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*") 
public class OrderController {

    private final OrderService orderService;
    private final MenuService menuService;

    public OrderController(OrderService orderService, MenuService menuService) {
        this.orderService = orderService;
        this.menuService = menuService;
    }

    
    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto dto) {
        Order order = new Order();

        List<OrderItem> items = dto.getItems().stream().map(i -> {
            OrderItem item = new OrderItem();
            Menu menu = menuService.getById(i.getMenu_id());
            item.setMenu(menu);
            item.setQuantity(i.getQuantity());
            return item;
        }).collect(Collectors.toList());

        order.setItems(items);
        order.setOrder_date(dto.getOrder_date());  
        Order saved = orderService.create(order);

        return OrderMapper.toDto(saved);
    }

    
    public List<OrderResponseDto> getAll() {
        return orderService.getAll()
                .stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }

   
    public OrderResponseDto getById(@PathVariable Integer id) {
        return OrderMapper.toDto(orderService.getById(id));
    }

    
    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Integer id, @RequestBody OrderRequestDto dto) {
        Order order = orderService.getById(id);

        
        order.setOrder_date(dto.getOrder_date());

        
        order.getItems().clear();

        List<OrderItem> items = dto.getItems().stream().map(i -> {
            OrderItem item = new OrderItem();
            Menu menu = menuService.getById(i.getMenu_id());
            item.setMenu(menu);
            item.setQuantity(i.getQuantity());
            return item;
        }).collect(Collectors.toList());

        order.getItems().addAll(items);

        Order updated = orderService.update(order);

        return OrderMapper.toDto(updated);
    }

    // DELETE ORDER
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }
}
