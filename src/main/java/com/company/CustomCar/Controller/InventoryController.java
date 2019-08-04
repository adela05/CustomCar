package com.company.CustomCar.Controller;

import com.company.CustomCar.Dto.Inventory;
import com.company.CustomCar.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public List<Inventory> getInventory(){
        return inventoryService.getAllInventory();
    }
    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public Inventory addInventory(@RequestBody @Valid Inventory inventory){
        inventoryService.addInventory(inventory);
        return inventory;
    }
}
