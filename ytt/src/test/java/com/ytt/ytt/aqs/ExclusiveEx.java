package com.ytt.ytt.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ExclusiveEx {

    public static final ReentrantLock LOCK = new ReentrantLock();

    public static void exclusive() {
        // 互斥性
        System.out.println(Thread.currentThread().getName() + "开始运行");
        while (true) {
            System.out.println(Thread.currentThread().getName() + "开始加锁");
            LockSupport.park();
            if (Thread.interrupted())
                break;
            System.out.println(Thread.currentThread().getName() + "解锁成功");
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> exclusive());
        t1.start();
        try {
            Thread.sleep(1000);
//            LockSupport.unpark(t1);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
