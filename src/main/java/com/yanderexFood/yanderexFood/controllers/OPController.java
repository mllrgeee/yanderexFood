package com.yanderexFood.yanderexFood.controllers;

import com.yanderexFood.yanderexFood.models.OrderPlace;
import com.yanderexFood.yanderexFood.repositories.OrderPlaceRepository;
import com.yanderexFood.yanderexFood.service.OPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class OPController {
    @Autowired
    private OPService opService;
    @Autowired
    private OrderPlaceRepository orderPlaceRepository;
    @GetMapping("/shops")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<List<OrderPlace>> getShops() {
        return ResponseEntity.ok(opService.findAll());
    }
    @PostMapping("/shops/new")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> addOP(@RequestBody OrderPlace orderPlace) {
        orderPlaceRepository.save(orderPlace);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/shops/update/{id}")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> updateOP(@RequestBody OrderPlace orderPlace, @PathVariable("id") long id) {
        opService.updateOP(orderPlace, id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/shops/delete/{id}")
    @CrossOrigin("http://localhost:5173")
    public ResponseEntity<?> deleteOP(@PathVariable("id") long id) {
        opService.deleteOP(id);
        return ResponseEntity.ok().build();
    }
}
