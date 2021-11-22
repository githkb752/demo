package com.ytt.ytt.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier和CountDownLatch区别
 */
public class ThreadClassEx {

    public static final CyclicBarrier cyclic = new CyclicBarrier(5);
    public static final CountDownLatch LATCH = new CountDownLatch(5);
    public static int cyclicBarr = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> cyclic()).start();
        }
        try {
            LATCH.await();
            System.out.println(Thread.currentThread().getName() + "正在执行");
            LATCH.await();
            System.out.println(Thread.currentThread().getName() + "正在执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void cyclic() {
        try {
            cyclic.await();
            cyclicBarr++;
            System.out.println(Thread.currentThread().getName() + "正在执行");
            cyclic.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void countDown() {
        cyclicBarr++;
        System.out.println(Thread.currentThread().getName() + "cyclicBarr = " + cyclicBarr);
        LATCH.countDown();
    }
}
