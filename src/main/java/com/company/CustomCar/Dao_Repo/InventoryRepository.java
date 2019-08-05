package com.company.CustomCar.Dao_Repo;

import com.company.CustomCar.Dto.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByStatus(String status);

}
