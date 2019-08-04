package com.company.CustomCar.Service;

import com.company.CustomCar.Dao_Repo.InventoryRepository;
import com.company.CustomCar.Dao_Repo.ItemsRepository;
import com.company.CustomCar.Dto.Inventory;
import com.company.CustomCar.Dto.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepo;
    @Autowired
    ItemsRepository itemsRepo;

    public void updateInventory(Inventory inventory, Integer id){
        if(inventory.getInventoryId() == id){
            inventoryRepo.save(inventory);
        }
    }
    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }
    public Inventory getInventoryById(Integer id){
        return inventoryRepo.getOne(id);
    }


}
