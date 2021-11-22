package cn.nskjy.demo.thread;

public class SaleTicket {

    // 定义100张票
    private static int ticket = 100;
    private static Object obj = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                synchronized (obj) {
                    if (ticket > 0) {
                        ticket--;
                        System.out.println("线程" + Thread.currentThread().getName() + "拿到了，第" + (100 - ticket) + "张票");
                    }
                }
            });
            thread.start();
        }
    }

}
