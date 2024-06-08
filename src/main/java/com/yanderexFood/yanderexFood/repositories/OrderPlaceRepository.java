package com.yanderexFood.yanderexFood.repositories;

import com.yanderexFood.yanderexFood.models.OrderPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//ЭТО БАЗА
@Repository
public interface OrderPlaceRepository extends JpaRepository<OrderPlace, Long> {
    List<OrderPlace> findAll();
    OrderPlace findById(long id);
    @Transactional
    @Modifying
    @Query("update OrderPlace op set op.rank = ?1, op.address = ?2 where op.id = ?3")
    void updateOrderPlaceById(double rank, String address, long id);
    @Transactional
    void deleteOrderPlaceById(long id);
}
