package cn.nskjy.demo.new8;

import org.apache.poi.ss.formula.functions.T;

public class NewTest implements New8<T>{
    @Override
    public void new8(T t) {
        System.out.println(t);
    }

    public void test() {
        New8<T> tNew8 = reString(new NewTest());
        System.out.println(tNew8);
    }

    public static void main(String[] args) {
        new NewTest().test();
    }
}
