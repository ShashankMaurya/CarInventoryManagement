package com.automobile.automobile_inventory.Controller;

import com.automobile.automobile_inventory.Entity.Cars;
import com.automobile.automobile_inventory.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "api/cars")
public class CarsController {

    @Autowired
    private CarsRepository carsRepository;

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Cars>> getCarsAll() {
        return ResponseEntity.ok((ArrayList<Cars>) carsRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cars> getCar(@PathVariable int id) {
        return ResponseEntity.ok(carsRepository.findById(id).get());
    }

    @PostMapping("/add")
    public ResponseEntity<Cars> insertTruck(@RequestBody Cars car) {
        return ResponseEntity.ok(carsRepository.save(car));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cars> updateTruck(@PathVariable int id, @RequestBody Cars car) {
        Cars c = carsRepository.findById(id).get();

        c.setYear(car.getYear());
        c.setModel(car.getModel());
        c.setPrice(car.getPrice());
        c.setMake(car.getMake());

        return ResponseEntity.ok(carsRepository.save(c));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeCar(@PathVariable int id) {
        carsRepository.deleteById(id);
        return ResponseEntity.ok("Success");
    }
}
