package com.yanderexFood.yanderexFood.repositories;

import com.yanderexFood.yanderexFood.models.Food;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//ЭТО БАЗА
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
    Food findById(long id);
    List<Food> findByTitle(String title);
    List<Food> findByCategory(String title);
    List<Food> findByCalory(double calory);
    @Transactional
    @Modifying
    //BDSM код
    @Query("update Food f set f.title = ?1, f.category = ?2, f.calory = ?3, f.price = ?4 where f.id = ?5")
    void updateFoodById(String title, String category, double calory, double price, long id);
    @Transactional
    void deleteFoodById(long id);
}
