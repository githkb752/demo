package cn.nskjy.demo.text;

import org.junit.Test;

public class Demo {

    @Test
    public synchronized void demo03() {
        Object l = 3;
        if (l instanceof Integer) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
