package com.company.CustomCar.Dao_Repo;

import com.company.CustomCar.Dto.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}