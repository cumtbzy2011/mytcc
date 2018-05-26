package test.com.bian.product.order.service;

import com.bian.product.order.OrderBootstrap;
import com.bian.product.order.jooq.tables.pojos.Order;
import com.bian.product.order.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * OrderServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderBootstrap.class)
public class OrderServiceImplTest {
    @Autowired
    OrderServiceImpl orderService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Order order)
     */
    @Test
    @Rollback
    @Transactional
    public void testInsert() throws Exception {
        Order order = new Order();
        Integer insert = orderService.insert(order);
        Assert.assertEquals(1, (int) insert);
    }

    @Test
    public void testFindAll() {
        List<Order> orders = orderService.findAll();
        System.out.println(orders);
        Assert.assertNotEquals(0, orders.size());
    }
}
