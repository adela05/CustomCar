package com.company.CustomCar.Service;

import com.company.CustomCar.Dao_Repo.SupplierRepository;
import com.company.CustomCar.Dto.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepo;

    public Supplier addSupplier(Supplier supplier){
        supplierRepo.save(supplier);
        return supplier;
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepo.findAll();
    }

    public Supplier getSupplierById(Integer id){
        return supplierRepo.getOne(id);
    }

    public void deleteSupplier(Integer id){
        supplierRepo.deleteById(id);
    }
}