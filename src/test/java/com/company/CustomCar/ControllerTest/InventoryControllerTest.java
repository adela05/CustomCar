package com.company.CustomCar.ControllerTest;

import com.company.CustomCar.Controller.InventoryController;
import com.company.CustomCar.Dto.Inventory;
import com.company.CustomCar.Service.InventoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class InventoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    InventoryService mockInventService;

    @InjectMocks
    InventoryController inventController;

    Inventory item1;
    Inventory item2;

    List<Inventory> itemList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(inventController).build();

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

        itemList = Arrays.asList(item1, item2);
    }

    @Test
    public void ShouldReturnAllItems() throws Exception{
        when(mockInventService.getAllInventory()).thenReturn(itemList);

        mockMvc.perform(get("/inventory"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].status").value(itemList.get(0).getStatus()));
        verify(mockInventService).getAllInventory();
    }
}
