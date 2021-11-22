package cn.nskjy.demo.new8;

import java.util.Arrays;
import java.util.List;

/**
 * lambda表达式代替foreach
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
//        for (String lists : list) {
//            System.out.println(lists);
//        }
        list.forEach(System.out::println);
    }
}
