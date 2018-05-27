package test.com.bian.order.service;

import com.bian.order.OrderBootstrap;
import com.bian.order.feign.ProductClient;
import com.bian.order.jooq.tables.pojos.Conflict;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.service.ConflictServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ConflictServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderBootstrap.class)
public class ConflictServiceImplTest {
    @Autowired
    ConflictServiceImpl conflictService;
    @Autowired
    ProductClient productClient;

    @Test
    public void testClient() {
        ObjectDataResponse<String> result = productClient.test(101L);

        Assert.assertNotNull(result);

        System.out.println(result.getData());
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Conflict conflict)
     */
    @Test
    public void testInsert() throws Exception {
        int insert = conflictService.insert(new Conflict());
        Assert.assertEquals(1, insert);
    }


} 
