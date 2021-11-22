package cn.nskjy.demo.new8.demo2;

import org.junit.Test;

public class TestLambda {

    public String change(String str, FunctionTest function) {
        String value = function.getValue(str);
        return value;
    }

    public long math(long long1, long long2, Lambda02<Long,Long> lambda02) {
        return lambda02.get(long1, long2);
    }

    @Test
    public void getResult() {
        System.out.println(math(700L, 800L, (long1, long2) -> long1*long2));
    }

    @Test
    public void getStr() {
        System.out.println(change("abcefg", str -> str.substring(2, 4)));
    }

    @Test
    public void test() {


    }
}
