package com.ytt.ytt.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class AdvantageEx implements Callable, Runnable {

    public static void ex1() {
        System.out.println(Thread.currentThread().getName() + "执行完成");
    }

    public static void ex2() {
        System.out.println(Thread.currentThread().getName() + "执行完成");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> ex1());
        Thread t2 = new Thread(() -> ex2());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println(Thread.currentThread().getName() + "执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    @Override
    public void run() {

    }
}
