package cn.nskjy.demo.design.singleton;

public class DelaySafeSingleton1 {

    private DelaySafeSingleton1() {}

    private static DelaySafeSingleton1 instance;

    private static Object obj = new Object();

    public DelaySafeSingleton1 getInstance() {
        synchronized (obj) {
            if (null == instance)
                instance = new DelaySafeSingleton1();
        }
        return instance;
    }
}
