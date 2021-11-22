package cn.nskjy.demo.design.singleton;

public class DelaySafeSingleton2 {

    private DelaySafeSingleton2() {}

    private static Object obj = new Object();

    private volatile static DelaySafeSingleton2 instance;

    public static DelaySafeSingleton2 getInstance() {
        if (null == instance) {
            synchronized (obj) {
                if (null == instance)
                    instance = new DelaySafeSingleton2();
            }
        }
        return instance;
    }
}
