package com.example.restaurant.repository;

//import java.util.List;

import com.example.restaurant.entity.Category;
//import com.example.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


 


public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    com.example.restaurant.entity.Category save(com.example.restaurant.entity.Category category);
//    List<Category> findAll(Category category);
//    Menu findById(com.example.restaurant.entity.Category category);
}
