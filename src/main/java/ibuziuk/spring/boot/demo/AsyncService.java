package ibuziuk.spring.boot.demo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncService {
    private static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);

    
    @Async
    public void processAsync() {
        long startTime = System.nanoTime();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        long endTime = System.nanoTime();
        long durationNano = (endTime - startTime);
        long durationSeconds = TimeUnit.SECONDS.convert(durationNano, TimeUnit.NANOSECONDS);
        LOG.info("Async startup took (nano seconds): {}", Long.toString(durationNano));
        LOG.info("Async startup took (seconds): {}", durationSeconds);
    }

}
