package cn.nskjy.demo.queue.ex;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Consumer implements Runnable {

    /**
     * 阻塞队列
     */
    private LinkedBlockingDeque<Task> blockingDeque = null;

    public Consumer(LinkedBlockingDeque<Task> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = blockingDeque.take();

                // 收到毒丸任务将毒丸放回队列头，结束当前线程.
                if (task.getTaskEndType() != EnumTaskEndType.NA) {
                    log.info("收到毒丸任务.{}", task);
                    blockingDeque.offerFirst(task, 2, TimeUnit.MILLISECONDS);
                    break;
                }

                // 消费任务. 这里可以写实际的业务逻辑.
                log.info("消费任务：{}", task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("消费者结束消费.");
    }
}
