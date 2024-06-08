package com.yanderexFood.yanderexFood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //геты сеты для полей
@NoArgsConstructor //конструктор без полей
@AllArgsConstructor //конструктор с полями
//Фут (НЕ ФЕТИШ !!!)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "calory")
    private double calory;
    @Column(name = "price")
    private double price;
}
