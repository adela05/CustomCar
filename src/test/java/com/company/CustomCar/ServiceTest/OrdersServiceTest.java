package com.company.CustomCar.ServiceTest;

import com.company.CustomCar.Dao_Repo.OrdersRepository;
import com.company.CustomCar.Dto.Orders;
import com.company.CustomCar.Service.OrdersService;
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
public class OrdersServiceTest {
    @Mock
    @Autowired
    OrdersRepository ordersRepoMock;
    @InjectMocks
    OrdersService ordersService;

    Orders order1;
    Orders order2;

    List<Orders> ordersList;

    @Before
    public void setup(){
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
    public void shouldGetAllItems(){
        List <Orders> expectedList = Arrays.asList(order1, order2);

        when(ordersRepoMock.findAll()).thenReturn(ordersList);
        assertEquals(expectedList, ordersService.addOrders(order1));
        assertEquals(expectedList, ordersService.addOrders(order2));
    }
}
