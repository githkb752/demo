package cn.nskjy.demo.fanxing;

import java.util.ArrayList;

/**
 * 证明泛型只是在编译阶段有效
 * 在编译之后程序会采取去泛型化的措施
 */
public class TestFX {
    public static Boolean fx() {
        ArrayList<String> strings = new ArrayList();
        ArrayList<Integer> integers = new ArrayList();
        Class<? extends ArrayList> aClass = strings.getClass();
        Class<? extends ArrayList> aClass1 = integers.getClass();
        boolean b = aClass.equals(aClass1);
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fx());
    }
}
