package com.company.CustomCar.ControllerTest;

import com.company.CustomCar.Controller.OrdersController;
import com.company.CustomCar.Dto.Orders;
import com.company.CustomCar.Service.OrdersService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrdersControllerTest {
    private MockMvc mockMvc;

    @Mock
    OrdersService mockOrdersService;

    @InjectMocks
    OrdersController ordersController;

    Orders order1;
    Orders order2;

    List<Orders> ordersList;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();

        order1 = new Orders();
        order1.setOrderId(1);
        order1.setOrderQty(1);
        order1.setStartDate("01-22-2019");
        order1.setCompletionDate("11-05-2019");
        order1.setInventoryId(1);

        order2 = new Orders();
        order2.setOrderId(2);
        order2.setOrderQty(2);
        order2.setStartDate("08-20-2019");
        order2.setCompletionDate("02-28-2020");
        order2.setInventoryId(2);

        ordersList = Arrays.asList(order1, order2);
    }
    @Test
    public void shouldReturnAllOrders() throws Exception{
        when(mockOrdersService.getAllOrders()).thenReturn(ordersList);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].orderId").value(ordersList.get(0).getOrderId()));
    }
}
