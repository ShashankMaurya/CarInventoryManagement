package com.automobile.automobile_inventory.Repository;

import com.automobile.automobile_inventory.Entity.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<Cars, Integer> {
}
