package com.company.CustomCar.ServiceTest;

import com.company.CustomCar.Dao_Repo.InventoryRepository;
import com.company.CustomCar.Dto.Inventory;
import com.company.CustomCar.Service.InventoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {
    @Mock
    @Autowired
    InventoryRepository inventRepoMock;

    @InjectMocks
    InventoryService inventoryService;

    Inventory items1;
    Inventory items2;

    List<Inventory> itemsList;

    @Before
    public void setup(){
        items1 = new Inventory();
        items1.setStatus("used");
        items1.setItemId(1);
        items1.setPartType("Breaks");
        items1.setQuantity(80);
        items1.setPrice(150.0);
        items1.setVendorName("Supplier A");

        items2 = new Inventory();
        items2.setStatus("lost");
        items2.setItemId(2);
        items2.setPartType("Rims");
        items2.setQuantity(65);
        items2.setPrice(500.0);
        items2.setVendorName("Supplier A");

        itemsList = Arrays.asList(items1, items2);
    }

    @Test
    public void shouldGetAllItems(){
        List<Inventory> expectedList = Arrays.asList(items1, items2);
        when(inventRepoMock.findAll()).thenReturn(itemsList);
        assertEquals(expectedList, inventoryService.getAllInventory());
    }
}
