package cn.nskjy.demo.utils.thread;

import java.util.concurrent.*;

public class ThreadPoolUtil {

    public static ThreadPoolExecutor getThreadPool() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
        return threadPool;
    }
}
