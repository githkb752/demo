package cn.nskjy.demo.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NumbersProducer implements Runnable {

    private BlockingQueue<Integer> queue;
    private final int maxFlag;
    private final int flag;

    public NumbersProducer(BlockingQueue<Integer> queue, int maxFlag, int flag) {
        this.queue = queue;
        this.maxFlag = maxFlag;
        this.flag = flag;
    }

    public void sell() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            queue.put(ThreadLocalRandom.current().nextInt(99));
            log.info("第{}厨师制作了披萨", Thread.currentThread().getId());
        }

        for (int j = 0; j < flag; j++) {
            queue.put(maxFlag);
            log.info("第{}厨师制作了第{}个披萨", Thread.currentThread().getId(), maxFlag);
        }
    }

    @Override
    public void run() {
        try {
            sell();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
