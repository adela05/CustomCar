package com.company.CustomCar.DaoTest;

import com.company.CustomCar.Dao_Repo.InventoryRepository;
import com.company.CustomCar.Dto.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryDaoTest {

    @Autowired
    InventoryRepository inventRepo;

    Inventory item1;
    Inventory item2;

    @Before
    public void setUp(){
        item1 = new Inventory();
        item1.setStatus("used");
        item1.setItemId(1);
        item1.setPartType("Breaks");
        item1.setQuantity(80);
        item1.setPrice(150.0);
        item1.setVendorName("Supplier A");

        item2 = new Inventory();
        item2.setStatus("lost");
        item2.setItemId(2);
        item2.setPartType("Rims");
        item2.setQuantity(65);
        item2.setPrice(500.0);
        item2.setVendorName("Supplier A");

    }
    @Test
    @Transactional
    public void shouldAddInventory(){
        inventRepo.save(item1);
        inventRepo.save(item2);

        assertNotNull(item1.getInventoryId());
        assertNotNull(item2.getInventoryId());
    }

}
