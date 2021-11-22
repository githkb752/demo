package cn.nskjy.demo.design.singleton;

/**
 * 采用静态内部类，实现延迟加载
 */
public class InnerSingleton {

    private InnerSingleton() {}

    private static class Inner{
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return Inner.INSTANCE;
    }
}
