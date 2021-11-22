package cn.nskjy.demo.new8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式
 */
public class New2 {

    public static void main(String[] args) {
        // java8以前字符串排序
        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "ddd");
//        Collections.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.print(list + "\n");
        System.out.println(list);

        // java8以后字符串排序
        Collections.sort(list, String::compareTo);
        System.out.println(list);
    }
}
