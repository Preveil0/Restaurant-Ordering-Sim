package com.example.restaurant.service;

import com.example.restaurant.entity.OrderItem;
import com.example.restaurant.entity.Menu;
import com.example.restaurant.repository.OrderItemRepository;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem getById(Integer id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found: " + id));
    }

    public OrderItem save(OrderItem item) {

        Menu menu = menuRepository.findById(item.getMenu().getMenu_id())
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        item.setMenu(menu);

        return orderItemRepository.save(item);
    }

    public OrderItem update(Integer id, OrderItem newItem) {
        OrderItem existing = getById(id);

        existing.setQuantity(newItem.getQuantity());
        existing.setPrice_paid(newItem.getPrice_paid());

        if (newItem.getMenu() != null) {
            Menu menu = menuRepository.findById(newItem.getMenu().getMenu_id())
                    .orElseThrow(() -> new RuntimeException("Menu not found"));
            existing.setMenu(menu);
        }

        return orderItemRepository.save(existing);
    }

    public void delete(Integer id) {
        orderItemRepository.deleteById(id);
    }

    public OrderItem update(OrderItem item) {
        return item;
        
    }
}
