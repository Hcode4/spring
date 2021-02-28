package com.vivo.spring.service.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/2/26 20:50
 **/
@Slf4j
public class CountDownLatchDemo {

    public static void main(String[] args) {
        countDownLatch();
    }

    static ExecutorService executorService = Executors.newScheduledThreadPool(10);
    static final CountDownLatch latch = new CountDownLatch(3);

    public static void countDownLatch() {

        for(int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(), "work"));
                        latch.countDown();
                    } catch (Exception e) {
                        log.info(String.format("方法：%s 第：%s, 错误信息：",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber()),e);
                    }
                }
            };
            executorService.execute(runnable);
        }

        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),"等待执行"));

        try {
            latch.await();
        } catch (Exception e) {
            log.info(String.format("方法：%s 第：%s, 错误信息：",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber()),e);
        }
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),"等待执行完毕"));
    }

}
