package cn.nskjy.demo.design.singleton;

public class DelaySafeSingleton {

    private DelaySafeSingleton(){}

    private static DelaySafeSingleton instance;

    public static synchronized DelaySafeSingleton getInstance() {
        if (null == instance) {
            instance = new DelaySafeSingleton();
        }
        return instance;
    }
}
