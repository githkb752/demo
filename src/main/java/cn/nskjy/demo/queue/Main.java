package cn.nskjy.demo.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        int bound = 10;
//        int maxFlag = Integer.MAX_VALUE;
        int maxFlag = 100;
        int n_produces = 8;
        int n_cusumers = Runtime.getRuntime().availableProcessors(); // 4
        int falseFlag = n_cusumers/n_produces;
        int trueFlag = 5;

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(bound);

        for (int i = 0; i < n_produces; i++) {
            new Thread(new NumbersProducer(blockingQueue,maxFlag,falseFlag)).start();
        }

        for (int i = 0; i < n_cusumers; i++) {
            new Thread(new NumbersComsumer(blockingQueue, maxFlag)).start();
        }

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new NumbersProducer(blockingQueue, maxFlag, trueFlag)).start();

    }
}
