package com.example.restaurant.controller;

import com.example.restaurant.dto.menu.MenuRequestDto;
import com.example.restaurant.dto.menu.MenuResponseDto;
import com.example.restaurant.mapper.MenuMapper;
import com.example.restaurant.service.MenuService;
import com.example.restaurant.entity.Menu;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<MenuResponseDto> getAll() {
        return menuService.getAllMenus()
                .stream()
                .map(MenuMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MenuResponseDto getById(@PathVariable Integer id) {
        return MenuMapper.toDto(menuService.getById(id));
    }

    @PostMapping
    public MenuResponseDto create(@RequestBody MenuRequestDto dto) {
        Menu savedMenu = menuService.save(dto);
        return MenuMapper.toDto(savedMenu);
    }

    @PutMapping("/{id}")
    public MenuResponseDto update(@PathVariable Integer id, @RequestBody MenuRequestDto dto) {
        Menu updatedMenu = menuService.update(id, dto);
        return MenuMapper.toDto(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        menuService.delete(id);
    }

    
}
