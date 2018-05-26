package test.com.bian.product.service;

import com.bian.product.ProductBootstrap;
import com.bian.product.jooq.tables.pojos.Productstocktcc;
import com.bian.product.service.ProductstocktccServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductstocktccServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductBootstrap.class)
public class ProductstocktccServiceImplTest {

    @Autowired
    ProductstocktccServiceImpl productstocktccService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Productstocktcc productstocktcc)
     */
    @Test
    public void testInsert() throws Exception {
        int insert = productstocktccService.insert(new Productstocktcc());
        Assert.assertEquals(1, insert);
    }


} 
