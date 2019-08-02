package com.company.CustomCar.Dao_Repo;

import com.company.CustomCar.Dto.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
