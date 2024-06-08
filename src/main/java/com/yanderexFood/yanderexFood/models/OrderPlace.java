package com.yanderexFood.yanderexFood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //геты сеты для полей
@NoArgsConstructor //конструктор без полей
@AllArgsConstructor //конструктор с полями
//Шаурма маркет
public class OrderPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rank")
    private double rank;
    @Column(name = "address")
    private String address;
}
