package com.yanderexFood.yanderexFood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //геты сеты для полей
@NoArgsConstructor //конструктор без полей
@AllArgsConstructor //конструктор с полями
//Баскет (не куроко)
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_userId")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    @ManyToOne
    @JoinColumn(name = "order_place_id")
    private OrderPlace orderPlace;
}
