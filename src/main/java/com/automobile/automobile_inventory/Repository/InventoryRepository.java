package com.automobile.automobile_inventory.Repository;

import com.automobile.automobile_inventory.Entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
