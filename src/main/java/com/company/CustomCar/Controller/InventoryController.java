package com.company.CustomCar.Controller;

import com.company.CustomCar.Dto.Inventory;
import com.company.CustomCar.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public Inventory addInventory(@RequestBody @Valid Inventory inventory){
        inventoryService.addInventory(inventory);
        return inventory;
    }

    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    public void updateInventory(@RequestBody Inventory inventory, @PathVariable Integer id){
        inventoryService.updateInventory(inventory, id);
    }
    // This route will only delete lost and defective items.
    @RequestMapping(value = "/inventory", method = RequestMethod.DELETE)
    public void deleteByStatus(){
        inventoryService.deleteByStatus();
    }

    // This route will display the low inventory
    @GetMapping(value = "/inventory/quantity")
    public List<Inventory> getLowInventory(){
       return inventoryService.getLowInventory();
    }
}
