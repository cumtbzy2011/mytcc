package com.bian.user.service;

import com.bian.user.UserBootstrap;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import org.jooq.types.ULong;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * UserbalancetccServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 28, 2018</pre>
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
        Userbalancetcc userbalancetcc = new Userbalancetcc();
        userbalancetcc.setAmount(1L);
        userbalancetcc.setExpireTime(Timestamp.valueOf(LocalDateTime.now()));
        userbalancetcc.setTUserId(ULong.valueOf(1));
        int insert = userbalancetccService.insert(userbalancetcc);
        Assert.assertEquals(1, insert);
        System.out.println(userbalancetcc.getId());
        Assert.assertNotNull(userbalancetcc.getId());
    }

    /**
     * Method: trying(Long userId, long amount)
     */
    @Test
    public void testTryingForUserIdAmount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: trying(User user, long amount, long expireSeconds)
     */
    @Test
    public void testTryingForUserAmountExpireSeconds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: confirmReservation(Long id)
     */
    @Test
    public void testConfirmReservation() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: cancelReservation(Long id)
     */
    @Test
    public void testCancelReservation() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: selectUserById(Long userId)
     */
    @Test
    public void testSelectUserById() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = UserbalancetccServiceImpl.getClass().getMethod("selectUserById", Long.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: consumeBalance(ULong userId, Long amount)
     */
    @Test
    public void testConsumeBalance() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = UserbalancetccServiceImpl.getClass().getMethod("consumeBalance", ULong.class, Long.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: selectTccById(Long id)
     */
    @Test
    public void testSelectTccById() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = UserbalancetccServiceImpl.getClass().getMethod("selectTccById", Long.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: updateToConfirmationById(ULong id)
     */
    @Test
    public void testUpdateToConfirmationById() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = UserbalancetccServiceImpl.getClass().getMethod("updateToConfirmationById", ULong.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: deleteTryingById(ULong id)
     */
    @Test
    public void testDeleteTryingById() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = UserbalancetccServiceImpl.getClass().getMethod("deleteTryingById", ULong.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
