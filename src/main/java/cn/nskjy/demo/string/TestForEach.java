package cn.nskjy.demo.string;

import org.junit.Test;

public class TestForEach {
    @Test
    public void test() {
        String[] str = new String[] {"aa","bb","cc"};
        int len = str.length;
        int i = 0;
        while ( i < len) {
            System.out.println(str[i]);
            i++;
        }
        /*for (int i = 0,len = str.length; i < len; i++) {
            System.out.println(str[i]);
        }*/
    }
}
