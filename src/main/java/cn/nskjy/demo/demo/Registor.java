package cn.nskjy.demo.demo;

import java.util.Collections;
import java.util.List;

/**
 * @author YINTINGTING001
 * @date 2021/12/1 17:54
 */
public class Registor {

    public static void registor(String... registors) {
        System.out.println(registors.toString());
        for (String registor : registors) {
            System.out.println(registor);
        }
    }

    public static void main(String[] args) {
        String[] str = new String[]{"1"};
        registor("1");
    }
}
