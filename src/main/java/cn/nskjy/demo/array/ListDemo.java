package cn.nskjy.demo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YINTINGTING001
 * @date 2021/12/2 12:02
 */
public class ListDemo {

    public static TwoArray demo(TwoArray twoArray) {
        twoArray = new TwoArray();
        return twoArray;
    }

    public static void main(String[] args) {
        TwoArray twoArray = new TwoArray();
        System.out.println(twoArray);
        twoArray = demo(twoArray);
        System.out.println(twoArray);
    }
}
