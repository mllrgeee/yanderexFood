package com.yanderexFood.yanderexFood.service;

import com.yanderexFood.yanderexFood.models.Food;
import com.yanderexFood.yanderexFood.models.OrderPlace;
import com.yanderexFood.yanderexFood.repositories.OrderPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OPService {
    @Autowired
    private OrderPlaceRepository orderPlaceRepository;
    public List<OrderPlace> findAll() {
        return orderPlaceRepository.findAll();
    }
    public void updateOP(OrderPlace orderPlace, long id) {
        orderPlaceRepository.updateOrderPlaceById(orderPlace.getRank(), orderPlace.getAddress(), id);
    }
    public void deleteOP(long id) {
        orderPlaceRepository.deleteOrderPlaceById(id);
    }
}
