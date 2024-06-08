package com.yanderexFood.yanderexFood.service;

import com.yanderexFood.yanderexFood.models.Food;
import com.yanderexFood.yanderexFood.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Сервис доставки еды
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    public List<Food> findAll() {
        return foodRepository.findAll();
    }
    public void updateFood(Food food, long id) {
        foodRepository.updateFoodById(food.getTitle(), food.getCategory(), food.getCalory(), food.getPrice(), id);
    }
    public void deleteFood(long id) {
        foodRepository.deleteFoodById(id);
    }
}
