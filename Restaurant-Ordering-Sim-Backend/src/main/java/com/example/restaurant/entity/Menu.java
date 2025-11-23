package com.example.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menu_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = 50)
    private String item_name;

    @Column(length = 250)
    private String description;

    @Lob
    private byte[] image;

    private Double price;


  
    }


