package com.company.CustomCar.Controller;

import com.company.CustomCar.Dto.Items;
import com.company.CustomCar.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public Items addItem(@RequestBody @Valid Items item){
        return itemsService.addItem(item);
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Items> getAllItems(){
        return itemsService.getAllItems();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Items getItemById(@PathVariable Integer id){
        return itemsService.getItemById(id);
    }

    
}
