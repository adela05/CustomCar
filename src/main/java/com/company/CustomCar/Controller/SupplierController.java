package com.company.CustomCar.Controller;

import com.company.CustomCar.Dto.Items;
import com.company.CustomCar.Dto.Supplier;
import com.company.CustomCar.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/suppliers", method = RequestMethod.POST)
    public Supplier addSupplier(@RequestBody @Valid Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }
    @RequestMapping(value = "/suppliers/{id}", method = RequestMethod.GET)
    public Supplier getSupplierById(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }
    @RequestMapping(value = "/suppliers/{id}", method = RequestMethod.DELETE)
    public void deleteSupplier(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
    }
}
