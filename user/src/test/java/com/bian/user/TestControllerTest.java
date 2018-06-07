package com.bian.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 6, 2018</pre>
 */
@SpringBootTest(classes = UserBootstrap.class)
@RunWith(SpringRunner.class)
public class TestControllerTest {

    @Autowired
    TestController testController;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: test()
     */
    @Test
    public void testTest() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: test2()
     */
    @Test
    public void testTest2() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: test3()
     */
    @Test
    public void testTest3() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setRedis()
     */
    @Test
    public void testSetRedis() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getRedis()
     */
    @Test
    public void testGetRedis() throws Exception {
        testController.setRedis();
        Object result = testController.getRedis();
        Assert.assertEquals("test1", result.toString());
    }


    @Test
    public void testtestWatch1() {
        Object o = testController.testWatch1();
        Assert.assertNotNull(o);
    }
}
