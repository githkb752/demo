package cn.nskjy.demo.design.singleton;

/**
 * 优点：方法实现比较简单，运用类的加载机制，避免了线程同步问题
 * 缺点：加载类时，就会创建实例。不能按需加载
 */
public class HungarySingletion {

    private HungarySingletion() {}

    private static HungarySingletion instance = new HungarySingletion();

    public HungarySingletion getInstance(){
        return instance;
    }
}
