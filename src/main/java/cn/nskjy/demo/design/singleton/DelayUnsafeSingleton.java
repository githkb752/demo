package cn.nskjy.demo.design.singleton;

/**
 * 懒加载
 * 只能单线程使用
 */
public class DelayUnsafeSingleton {

    private DelayUnsafeSingleton() {}

    private static DelayUnsafeSingleton instance;

    public static DelayUnsafeSingleton getInstance() {
        if (null == instance)
            instance = new DelayUnsafeSingleton();
        return instance;
    }
}
