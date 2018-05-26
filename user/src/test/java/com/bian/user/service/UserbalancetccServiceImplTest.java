package com.bian.user.service;

import com.bian.user.UserBootstrap;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserbalancetccServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserBootstrap.class)
public class UserbalancetccServiceImplTest {

    @Autowired
    UserbalancetccServiceImpl userbalancetccService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Userbalancetcc userbalancetcc)
     */
    @Test
    public void testInsert() throws Exception {
        int insert = userbalancetccService.insert(new Userbalancetcc());
        Assert.assertEquals(1, insert);
    }


} 
