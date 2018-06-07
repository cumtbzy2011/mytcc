package com.bian.ratelimiter;


import com.google.common.util.concurrent.RateLimiter;

import java.util.LinkedHashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

//和Semaphore相比，Semaphore控制了并发访问数量，而RateLimiter控制了访问速度
//比如控制1s内能访问1000次，这1000次可能是1个线程访问的，而Semaphore和时间维度无关，只保证同一时刻能有多少线程访问
public class LimiterTest {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(1000);

        Executor executor = Executors.newFixedThreadPool(4);

        AtomicLong count = new AtomicLong();

        ScheduledExecutorService printer = Executors.newScheduledThreadPool(1);
        printer.scheduleAtFixedRate(() -> System.out.println(count.toString()), 1, 1, TimeUnit.SECONDS);

        Stream.iterate(0, n -> n)
          .limit(4)
          .forEach(i -> executor.execute(() -> {
              while (true) {
                  rateLimiter.acquire();
                  count.incrementAndGet();
              }
          }));
        new ArrayBlockingQueue(1).peek();
    }
}
