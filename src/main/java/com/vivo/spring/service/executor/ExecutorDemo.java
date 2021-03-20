package com.vivo.spring.service.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/2/28 15:34
 **/
@Slf4j
public class ExecutorDemo {

    static final Executor executorSingle = Executors.newSingleThreadExecutor();

    static final Executor executorFix = Executors.newFixedThreadPool(10);

    static final Executor executorCache = Executors.newCachedThreadPool();

    static final Executor executorSchedule = Executors.newScheduledThreadPool(10);

    final ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));

    public static void main(String []args) {
        List<String> values = new ArrayList<>();

        Collections.reverse(values);
    }

}
