package cn.nskjy.demo.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
public class NumbersComsumer implements Runnable {

    private BlockingQueue<Integer> queue;

    private final int maxFlag;

    public NumbersComsumer(BlockingQueue<Integer> queue, int maxFlag) {
        this.queue = queue;
        this.maxFlag = maxFlag;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(maxFlag)) {
                    log.info("顾客-{}取走了{}个披萨,披萨全部售完-------------------", Thread.currentThread().getId(), number.intValue());
                    return;
                }
                log.info("顾客-{}取走了{}个披萨", Thread.currentThread().getId(), number.intValue());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
