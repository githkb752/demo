package cn.nskjy.demo.string;

import org.junit.Test;

public class StringTrim {

    @Test
    public void deleteStr() {
        String str = "   智慧城市  " + "\r\n";
        String string = "智慧城市";
        System.out.println(str);
        System.out.println(string);
        String trim = str.trim();
        System.out.println("trim=" + trim + "...");
    }
}
