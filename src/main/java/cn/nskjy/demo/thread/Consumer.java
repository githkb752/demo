package cn.nskjy.demo.thread;

import java.util.Queue;

class Consumer implements Runnable {
    private Queue<Foods> queue;

    public Consumer(Queue<Foods> queue) {
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
                if (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "容器已空，开始生产");
                    this.queue.notifyAll();
                } else {
                    Foods Foods = this.queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费了一个" + Foods);
                }
            }
        }
    }
}
