package cn.nskjy.demo.thread;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;

class Producer implements Runnable {
    private final Queue<Foods> queue;

    public Producer(Queue<Foods> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.queue) {
                if (queue.size() >= 3) {
                    System.out.println(Thread.currentThread().getName() + "容器已满，停止生产");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    String id = UUID.randomUUID().toString();
                    String name = "包子";
                    Double price = new Random().nextDouble();
                    Foods Foods = new Foods(id, name, price);
                    queue.add(Foods);
                    System.out.println(Thread.currentThread().getName() + "生产了一个" + Foods);
                }
            }
        }
    }
}
