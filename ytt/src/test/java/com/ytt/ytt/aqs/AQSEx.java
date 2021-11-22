package com.ytt.ytt.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS特性
 */
@Slf4j
public class AQSEx {

    // 定义显示锁
    public static final ReentrantLock LOCK = new ReentrantLock(true);
    // 临界资源
    public static int resource = 0;
    // 当前线程
    public static Thread current = null;

    public static void main(String[] args) {
        // 阻塞等待队列
        blockWaitQueue();
        // 独享/互斥
        // 定义十个线程去自增临界资源
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> exclusive()).start();
//        }
//
//        try {
//            Thread.sleep(1000);
//            current = Thread.currentThread();
//            // park主线程
//            LockSupport.park(current);
//            System.out.println(resource);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 公平/非公平
        long start = System.currentTimeMillis();
        new Thread(() -> fairSync()).start();

        current = Thread.currentThread();
        LockSupport.park();
        long end = System.currentTimeMillis();
        System.out.println("公平锁10个线程处理100000000个任务耗时" + (end - start) + "-" + resource);
        // 可重入
        reentrant();
        // 可中断
        interrupt();
    }

    /**
     * 阻塞等待队列
     */
    public static void blockWaitQueue() {

    }

    /**
     * 独享/互斥
     */
    public static void exclusive() {
        // 1. 互斥
        try {
            LOCK.lock();
            resource++;
            if (resource == 10 && null != current) {
                while (true) {
                    current.interrupt();
                    if (current.isInterrupted())
                        break;
                }
            }
        } finally {
            LOCK.unlock();
        }


    }

    /**
     * 公平/非公平
     */
    public static void fairSync() {
        try {
            LOCK.lock();
            for (int i = 0; i < 100000000; i++) {
                resource++;
            }
            if (resource == 100000000) {
                LockSupport.unpark(current);
            }
        } finally {
            LOCK.unlock();
        }


    }

    /**
     * 可重入
     */
    public static void reentrant() {

    }

    /**
     * 可中断
     */
    public static void interrupt() {

    }
}
