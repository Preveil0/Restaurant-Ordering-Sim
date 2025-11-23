package com.example.restaurant.controller;

import com.example.restaurant.dto.orderitem.OrderItemRequestDto;
import com.example.restaurant.dto.orderitem.OrderItemResponseDto;
import com.example.restaurant.entity.OrderItem;
// import com.example.restaurant.entity.Menu;
import com.example.restaurant.mapper.OrderItemMapper;
import com.example.restaurant.service.MenuService;
import com.example.restaurant.service.OrderItemService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "*")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final MenuService menuService;

    public OrderItemController(OrderItemService orderItemService, MenuService menuService) {
        this.orderItemService = orderItemService;
        this.menuService = menuService;
    }

    
    public List<OrderItemResponseDto> getAll() {
        return orderItemService.getAll()
                .stream()
                .map(OrderItemMapper::toDto)
                .collect(Collectors.toList());
    }

    
    public OrderItemResponseDto getById(@PathVariable Integer id) {
        return OrderItemMapper.toDto(orderItemService.getById(id));
    }

    
    @PostMapping
    public OrderItemResponseDto create(@RequestBody OrderItemRequestDto dto) {
        OrderItem item = new OrderItem();
        item.setQuantity(dto.getQuantity());
        item.setMenu(menuService.getById(dto.getMenu_id()));

        OrderItem saved = orderItemService.save(item);
        return OrderItemMapper.toDto(saved);
    }

   
    @PutMapping("/{id}")
    public OrderItemResponseDto update(@PathVariable Integer id, @RequestBody OrderItemRequestDto dto) {
        OrderItem item = orderItemService.getById(id);
        item.setQuantity(dto.getQuantity());
        item.setMenu(menuService.getById(dto.getMenu_id()));

        OrderItem updated = orderItemService.update(item);
        return OrderItemMapper.toDto(updated);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderItemService.delete(id);
    }
}
