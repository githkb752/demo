package cn.nskjy.demo.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void regex() {
        String str = "wowo1234nn4567";
        Pattern compile = Pattern.compile("([0-9]{4})");
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }

    public static void main(String[] args) {
        regex();
    }
}
