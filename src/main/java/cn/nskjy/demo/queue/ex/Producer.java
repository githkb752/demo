package cn.nskjy.demo.queue.ex;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Producer implements Runnable {

    private LinkedBlockingDeque<Task> blockingDeque = null;

    private final int taskAmount;

    public Producer(LinkedBlockingDeque<Task> blockingDeque, int taskAmount) {
        this.blockingDeque = blockingDeque;
        this.taskAmount = taskAmount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= taskAmount; ++i) {
            try {
                Task task = new Task();
                task.setTaskName("任务：" + i);
                blockingDeque.offer(task, 2, TimeUnit.MILLISECONDS);
                log.info("生产任务：{}", task);
            } catch (InterruptedException e) {
                log.error("创建任务异常.", e);
            }
        }

        // 放入毒丸任务已结束消费者线程
        try {
            Task task = new Task();
            task.setTaskName("任务处理结束毒丸");
            task.setTaskEndType(EnumTaskEndType.COMPLETE);
            blockingDeque.offer(task, 2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}