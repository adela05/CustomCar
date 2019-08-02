package com.company.CustomCar.Dao_Repo;

import com.company.CustomCar.Dto.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    List<Items> findBySupplierName(String name);
}
