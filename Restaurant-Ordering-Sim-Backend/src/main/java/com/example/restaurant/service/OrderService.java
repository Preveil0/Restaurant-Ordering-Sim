package com.example.restaurant.service;

import com.example.restaurant.entity.Order;
import com.example.restaurant.entity.OrderItem;
import com.example.restaurant.entity.Menu;
import com.example.restaurant.repository.OrderRepository;
import com.example.restaurant.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Order create(Order order) {

        order.setOrder_date(LocalDateTime.now());

        double total = 0;

        for (OrderItem item : order.getItems()) {

            Menu menu = menuRepository.findById(item.getMenu().getMenu_id())
                    .orElseThrow(() -> new RuntimeException("Menu not found"));

            item.setOrder(order);
            item.setPrice_paid(menu.getPrice());

            total += item.getQuantity() * item.getPrice_paid();
        }

        order.setTotal_amount(total);

        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order update(Order order) {
        
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
