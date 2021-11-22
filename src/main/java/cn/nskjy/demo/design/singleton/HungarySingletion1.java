package cn.nskjy.demo.design.singleton;

public class HungarySingletion1 {

    private HungarySingletion1() {}

    private static HungarySingletion1 instance;

    static {
        if (null == instance) {
            instance = new HungarySingletion1();
        }
    }

    public HungarySingletion1 getInstance() {
        return instance;
    }
}
