package cn.nskjy.demo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串常量池
 * 判断两个字符串是否相等，看字符串是否能在编译期间确定
 * new String()和变量 是不能在编译期间确定的 所以返回false
 * 自变量是可以在编译期间确定 所以返回true
 */
public class EquestString {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 80000; i++) {
            list.add(String.valueOf(i).intern());
        }
//        String str1 = new StringBuilder("计算机").append("技术").toString();
//        System.out.println(str1 == str1.intern());
//        String str = new String("计算机") + new String("技术");
//        String intern = str.intern();
//        System.out.println(str == intern);
//        String str1 = "a";
//        String str2 = "b";
//        String str3 = str1 + str2;
//        String str5 = str3.intern();
//        System.out.println(str3 == str5);
//        String s = str1 + str2;
//        String intern = s.intern();
//        System.out.println(s == intern);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2 == str2.intern());
//
//        String str3 = new String("aaabb1中");
//        System.out.println(str3 == str3.intern());
//        String s1 = new String("test");
//        String s2 = s1.intern();
//        System.out.println(s1 == s2);


//        String s0 = "ab";
//        String s1 = new String("a") + new String("b");
//        String s2 = s1.intern();
//        String s3 = "ab";
//        System.out.println(s2 == s1);
//        System.out.println(s1 == s2);
//        String s0 = "ytt";
//        String s1 = "ytt";
//        String s2 = "y" + "tt";
//        String t0 = new String("ytt");
//        String t1 = "y" + new String("tt");
//
//        String x0 = "y";
//        String x1 = "t";
//        String x2 = "t";
//        String x3 = x0 + x1 + x2;
//        String x5 = "y" + "t" + "t";
//        System.out.println(s0 == s1);
//        System.out.println(s2 == s1);
//        System.out.println(s2 == s0);
//        System.out.println(s0 == t0);
//        System.out.println(s0 == t1);
//        System.out.println(t0 == t1);
//        System.out.println(s0 == x3);
//        System.out.println(s0 == x5);
    }
}
