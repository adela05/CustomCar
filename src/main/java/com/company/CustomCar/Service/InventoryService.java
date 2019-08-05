package com.company.CustomCar.Service;

import com.company.CustomCar.Dao_Repo.InventoryRepository;
import com.company.CustomCar.Dao_Repo.ItemsRepository;
import com.company.CustomCar.Dto.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepo;
    @Autowired
    ItemsRepository itemsRepo;

    // Adding new items into inventory.
    public Inventory addInventory(Inventory inventory){
        inventoryRepo.save(inventory);
        return inventory;
    }
    public void addQuantity(Integer qty){
        ++qty;
    }
    // Updating items in inventory
    public void updateInventory(Inventory inventory, Integer id){
        if(inventory.getInventoryId()==id){
            inventoryRepo.save(inventory);
        }
    }
    // Listing all items in inventory
    public List<Inventory> getAllInventory(){
        return inventoryRepo.findAll();
    }

    public Inventory getInventoryById(Integer id) {
        return inventoryRepo.getOne(id);
    }
    public List<Inventory> getStatus(String status){
        return inventoryRepo.findByStatus(status);
    }
        // Deleting items that are lost or defective.
        public void deleteByStatus (){
        List<Inventory> statusList = inventoryRepo.findAll();
            for(int i = 0; i < statusList.size(); i++){
                if (statusList.get(i).getStatus().equals("lost") || statusList.get(i).getStatus().equals("defective")) {
                    inventoryRepo.deleteById(statusList.get(i).getInventoryId());
                }
            }
    }

    // Searching for Low Inventory that is less than qty 50.
    public Inventory getLowInventory(Integer quantity){
        List<Inventory> lowInventory = new ArrayList<>();
        List<Inventory> itemsList = inventoryRepo.findAll();
        for(int i = 0; i < itemsList.size(); i++){
            if(itemsList.get(i).getQuantity() < 50){
              lowInventory.add(itemsList.get(i));
            }
        }
        return getLowInventory(quantity);
    }

}
