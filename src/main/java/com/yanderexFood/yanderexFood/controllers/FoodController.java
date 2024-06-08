package com.yanderexFood.yanderexFood.controllers;

import com.yanderexFood.yanderexFood.models.Food;
import com.yanderexFood.yanderexFood.models.OrderPlace;
import com.yanderexFood.yanderexFood.repositories.FoodRepository;
import com.yanderexFood.yanderexFood.repositories.OrderPlaceRepository;
import com.yanderexFood.yanderexFood.service.FoodService;
import com.yanderexFood.yanderexFood.service.OPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodRepository foodRepository;
    @GetMapping("/food")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<List<Food>> getFood() {
        return ResponseEntity.ok(foodService.findAll());
    }
    @PostMapping("/food/new")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> addFood(@RequestBody Food food) {
        foodRepository.save(food);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/food/update/{id}")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> updateFood(@RequestBody Food food, @PathVariable("id") long id) {
        foodService.updateFood(food, id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/food/delete/{id}")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> deleteFood(@PathVariable("id") long id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok().build();
    }
}
