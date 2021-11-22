package cn.nskjy.demo.string;

import org.junit.Test;

public class SecondArray {

    @Test
    public void testArray() {
        for (int i = 1; i <= 15; i++) {
            for (int j = i; j <= i&& j > 0; j--) {
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
            System.out.println();
        }

    }
}
