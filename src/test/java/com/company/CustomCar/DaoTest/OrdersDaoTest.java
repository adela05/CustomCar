package com.company.CustomCar.DaoTest;

import com.company.CustomCar.Dao_Repo.OrdersRepository;
import com.company.CustomCar.Dto.Orders;
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
public class OrdersDaoTest {
    @Autowired
    OrdersRepository ordersRepo;

    Orders order1;
    Orders order2;

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
    }
    @Test
    @Transactional
    public void shouldAddOrders(){
        ordersRepo.save(order1);
        ordersRepo.save(order2);

        assertNotNull(order1.getInventoryId());
        assertNotNull(order2.getInventoryId());
    }
}
