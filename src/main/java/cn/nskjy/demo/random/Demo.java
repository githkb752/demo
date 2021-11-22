package cn.nskjy.demo.random;

import java.util.Random;

public class Demo {
    public static int demo(int start, int end) {
        Random random = new Random();
        int i = random.nextInt(end/2 + 1)%(end - start + 1) + start;
        return i;
    }

    public static int demo1(int number) {
        Random random = new Random();
        int i = random.nextInt(number + 1);
        return i;
    }

    public static void main(String[] args) {
        System.out.println(demo(99,100));
        System.out.println(demo1(100));
    }
}
