package com.yanderexFood.yanderexFood.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //геты сеты для полей
@NoArgsConstructor //конструктор без полей
@AllArgsConstructor //конструктор с полями
//АБЬЮЗЕР
public class AppUser {
    @Id // помечает что поле будет id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // помечает что поле будет уникальным
    @Column(name = "userId")
    private long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
