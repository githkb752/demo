package cn.nskjy.demo.regex;

import java.util.HashSet;
import java.util.Set;

public class RegexTest {
    public static void main(String[] args) {
        String regex = "^[0-9]{0,8}\\.?[0-9]{0,2}";
        System.out.println("11111111.11".matches(regex));
//        Set<String> set = new HashSet<>();
//        set.add("ytt");
//        set.add("ytt");
//        set.add("y1");
//        System.out.println(set);

//        String regex = "^[\\u4e00-\\u9fa5]{1,10}[0-9]{11}$";
////        String regex = "[0-9]{11}$";
//        String str = "殷庭庭殷庭庭殷庭庭11111111111";
//
//        if (str.matches(regex)) {
//            System.out.println("匹配成功");
//        } else {
//            System.out.println("匹配失败");
//        }
//        System.out.println(str.trim().substring(str.length() - 11));
//        System.out.println(str.trim().substring(0,str.length() - 11));
    }
}
