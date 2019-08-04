package com.company.CustomCar.Service;

import com.company.CustomCar.Dao_Repo.ItemsRepository;
import com.company.CustomCar.Dao_Repo.SupplierRepository;
import com.company.CustomCar.Dto.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepo;
    @Autowired
    private SupplierRepository supplierRepo;

    public Items addItem(Items item){
        itemsRepo.save(item);
        return item;
    }
    public List<Items> getAllItems(){
        return itemsRepo.findAll();
    }
    public Items getItemById(Integer id){
        return itemsRepo.getOne(id);
    }
    public void updateItem(Items item, Integer id){
        itemsRepo.save(item);
    }
    public void deleteItem(Integer id){
        itemsRepo.deleteById(id);
    }
    public List<Items> findByPartType(String name){
        return itemsRepo.findAll();
    }
}
