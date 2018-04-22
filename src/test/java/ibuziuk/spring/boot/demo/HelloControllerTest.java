package ibuziuk.spring.boot.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application.properties")
public class HelloControllerTest {
    @Value("${number.of.async.calls}")
    private String numberOfAsyncCalls;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAsync() throws Exception {
        assertEquals("50", numberOfAsyncCalls);
    }
}