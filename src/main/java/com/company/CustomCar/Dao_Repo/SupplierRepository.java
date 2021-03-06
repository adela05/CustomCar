package com.company.CustomCar.Dao_Repo;

import com.company.CustomCar.Dto.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByName(String name);
}
