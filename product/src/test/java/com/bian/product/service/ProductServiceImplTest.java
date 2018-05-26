package com.bian.product.service;

import com.bian.product.ProductBootstrap;
import com.bian.product.jooq.tables.pojos.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ProductServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductBootstrap.class)
public class ProductServiceImplTest {
    @Autowired
    ProductServiceImpl productService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll() throws Exception {
        List<Product> all = productService.findAll();
        Assert.assertNotEquals(0, all.size());
    }


} 
