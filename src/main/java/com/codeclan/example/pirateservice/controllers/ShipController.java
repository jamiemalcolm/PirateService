package com.codeclan.example.pirateservice.controllers;

import com.codeclan.example.pirateservice.models.Ship;
import com.codeclan.example.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class ShipController {
    @Autowired
    ShipRepository shipRepository;

    // the route we want to run this method on
    @GetMapping(value="/ships")
    public List<Ship> getAllShips(){
        return shipRepository.findAll();
    }

    @GetMapping(value = "/ships/{id}")
    public Optional<Ship> getShip(@PathVariable Long id){
        return shipRepository.findById(id);
    }


}
