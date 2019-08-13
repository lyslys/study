package com.learn.thread.mmall.example;

import com.learn.thread.mmall.annoations.NotThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.*;

@Slf4j
@NotThreadSafe
public class   ConcurrencyAtomic {

    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    @Getter
    public volatile int cc = 200;

    public static LongAdder count = new LongAdder();

    public static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception {
        tt();
//        t();
//        t1();
    }

    private static void tt() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    t2();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
//        log.info("conut:{}",count);
        log.info("execute {}",atomicBoolean.get());
    }

    private static void add(){
        count.increment();
    }

    private static AtomicReference<Integer> c = new AtomicReference(0);

    private static void t(){
        c.compareAndSet(0, 6);
        c.compareAndSet(1, 7);
        c.compareAndSet(2, 3);
        c.compareAndSet(6, 9);
        c.compareAndSet(0, 6);
        log.info("count:{}",c.get());
    }

    private static AtomicIntegerFieldUpdater<ConcurrencyAtomic> atomicAtomicIntegerFieldUpdater =
            AtomicIntegerFieldUpdater.newUpdater(ConcurrencyAtomic.class, "cc");

    private static void t1(){
        ConcurrencyAtomic concurrencyAtomic = new ConcurrencyAtomic();
        if(atomicAtomicIntegerFieldUpdater.compareAndSet(concurrencyAtomic, 200, 300)){
            log.info("update success 1 {}", concurrencyAtomic.getCc());
        }

        if(atomicAtomicIntegerFieldUpdater.compareAndSet(concurrencyAtomic, 200, 300)){
            log.info("update success 2", concurrencyAtomic.getCc());
        }else {
            log.info("update failed {}", concurrencyAtomic.getCc());
        }
    }


    private static void t2(){
        if(atomicBoolean.compareAndSet(false, true)){
            log.info("execute ");
        }
    }


}
