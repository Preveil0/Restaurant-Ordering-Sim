package com.example.restaurant.service;

import com.example.restaurant.dto.menu.MenuRequestDto;
import com.example.restaurant.entity.Category;
import com.example.restaurant.entity.Menu;
import com.example.restaurant.mapper.MenuMapper;
import com.example.restaurant.repository.CategoryRepository;
import com.example.restaurant.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public MenuService(MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    // GET ALL
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    // GET BY ID
    public Menu getById(Integer id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found: " + id));
    }

    // CREATE
    public Menu save(MenuRequestDto dto) {
        Menu menu = MenuMapper.toEntity(dto);

        // HANDLE CATEGORY
        if (dto.getCategory_id() != null) {
            Category category = categoryRepository.findById(dto.getCategory_id())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            menu.setCategory(category);
        }

        return menuRepository.save(menu);
    }

    // UPDATE
    public Menu update(Integer id, MenuRequestDto dto) {
    // Fetch existing menu
    Menu menu = getById(id);

    // Update simple fields
    menu.setItem_name(dto.getItem_name());
    menu.setDescription(dto.getDescription());
    menu.setImage(dto.getImage());
    menu.setPrice(dto.getPrice());

    // Update category if provided
    if (dto.getCategory_id() != null) {
        Category category = categoryRepository.findById(dto.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        menu.setCategory(category);
    }

    // Save changes
    return menuRepository.save(menu);
    }


    // DELETE
    public void delete(Integer id) {
        menuRepository.deleteById(id);
    }
}
