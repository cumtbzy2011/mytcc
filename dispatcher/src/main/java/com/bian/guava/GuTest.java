package com.bian.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class GuTest {
    public static void main(String[] args) {
//        ImmutableSet<String> hello = ImmutableSet.of("Hello", " ", "World");
//        System.out.println(hello);
//        HashBasedTable<String, String, Long> table = HashBasedTable.create();
//        table.put("name1", "name2", 1L);
//        Long aLong = table.get("name1", "name2");
//        System.out.println(aLong);

        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));
        ListenableFuture<String> future = executorService.submit(() -> {
            System.out.printf("the task is run by: %s\n", Thread.currentThread().getThreadGroup());
            Thread.sleep(10000);
            return "hello world!";
        });
        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String s) {
                System.out.println(Thread.currentThread().getThreadGroup().getName());
                System.out.println(s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.printf("the task is run by: %s\n", Thread.currentThread().getThreadGroup().getName());
                System.out.println(throwable.getMessage());
            }
        }, executorService);

        new ArrayBlockingQueue(1).peek();
    }
}
