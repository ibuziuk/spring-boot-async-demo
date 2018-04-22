package ibuziuk.spring.boot.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application.properties")
public class AsyncServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncServiceTest.class);

    
    @Value("${number.of.async.calls}")
    private String numberOfAsyncCalls;

    @Autowired
    AsyncService service;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAsync() throws Exception {
        for (int i = 0; i < Integer.valueOf(numberOfAsyncCalls); i++ ) {
            service.processAsync();
        }
        LOG.info("Sending {} async request finished. Now processing... ", numberOfAsyncCalls);
        TimeUnit.SECONDS.sleep(10);
    }
}