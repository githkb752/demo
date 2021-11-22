package cn.nskjy.demo.thread;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {

    @Test
    public void code1() {
        //生产者
        //消费者
        //容器
        Queue<Foods> queue = new LinkedList<>();
        Runnable produce = new Producer(queue);
        Runnable consumer = new Consumer(queue);

        //生产者线程
        for (int i = 0; i < 5; i++) {
            new Thread(produce, "生产者-" + i).start();
        }

        //消费者线程
        for (int i = 0; i < 2; i++) {
            new Thread(consumer, "消费者-" + i).start();
        }
    }
}
