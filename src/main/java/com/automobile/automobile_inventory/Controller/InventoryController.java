package com.automobile.automobile_inventory.Controller;

import com.automobile.automobile_inventory.Entity.Inventory;
import com.automobile.automobile_inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "api/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Inventory>> getInventoryAll() {
        return ResponseEntity.ok((ArrayList<Inventory>) inventoryRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Inventory> getInventory(@PathVariable int id) {
        return ResponseEntity.ok(inventoryRepository.findById(id).get());
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> insertInventory(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
        return ResponseEntity.ok(inventory.getId());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        Inventory i = inventoryRepository.findById(id).get();

        i.setCar_id(inventory.getCar_id());
        i.setQuantity(inventory.getQuantity());

        return ResponseEntity.ok(inventoryRepository.save(i));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Integer> removeInventory(@PathVariable int id) {
        inventoryRepository.deleteById(id);
        return ResponseEntity.ok(200);
    }
}