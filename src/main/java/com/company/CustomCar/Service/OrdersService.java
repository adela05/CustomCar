package com.company.CustomCar.Service;

import com.company.CustomCar.Dao_Repo.InventoryRepository;
import com.company.CustomCar.Dao_Repo.OrdersRepository;
import com.company.CustomCar.Dto.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepo;
    @Autowired
    InventoryRepository inventoryRepo;

    // Adding Order into the inventory.
    public Orders addOrders(Orders orders){
        ordersRepo.save(orders);
        return orders;
    }

    // Listing all orders
    public List<Orders> getAllOrders(){
        return ordersRepo.findAll();
    }
//    // Stuck on decrementing qty by startDate. Will need to fix in the future.
//    public void decrementOrder(String start, Integer orderQty){
//        List<Orders> startDate = ordersRepo.findAll();
//
//        for (int i = 0; i< startDate.size(); i++){
//           startDate.get(i).getStartDate() -- orderQty;
//        }
//    }


}
