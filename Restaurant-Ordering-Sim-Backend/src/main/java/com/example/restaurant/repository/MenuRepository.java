package com.example.restaurant.repository;

//import java.util.List;
//import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurant.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{
//    List<Category> setCategory();
}
