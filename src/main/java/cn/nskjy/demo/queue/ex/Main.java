package cn.nskjy.demo.queue.ex;

import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        LinkedBlockingDeque<Task> blockingDeque = new LinkedBlockingDeque<>();
        Producer producer = new Producer(blockingDeque, 100);

        new Thread(producer).start();

        Consumer consumer = new Consumer(blockingDeque);
        new Thread(consumer).start();
    }
}
