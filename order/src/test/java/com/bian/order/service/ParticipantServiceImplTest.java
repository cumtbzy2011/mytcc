package test.com.bian.order.service;

import com.bian.order.OrderBootstrap;
import com.bian.order.jooq.tables.pojos.Participant;
import com.bian.order.service.ParticipantServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ParticipantServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 26, 2018</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderBootstrap.class)
public class ParticipantServiceImplTest {
    @Autowired
    ParticipantServiceImpl participantService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insert(Participant participant)
     */
    @Test
    public void testInsert() throws Exception {
        int insert = participantService.insert(new Participant());
        Assert.assertEquals(1, insert);
    }


} 
