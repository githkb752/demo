package cn.nskjy.demo.regex;

public class Test1 {

    public static void match(String str, String regex) {
        if (str.matches(regex)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }

    }

    public static void main(String[] args) {
        String regex = "(.)*(.)\\2{2}(.)*";
        String regex1 = "^.*?([a-zA-Z\\d])\\1\\1.*?$";
        String str = "jiokgggh169";
        String str1 = "agAAAol";
        match(str1, regex1);
    }
}
