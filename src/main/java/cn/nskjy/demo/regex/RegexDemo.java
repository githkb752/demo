package cn.nskjy.demo.regex;

/**
 * 正则表达式[]代表一个元字符，[0-9]代表数字元字符, [a-z]代表字母元字符，
 * [0-9a-zA-z]代表一个数字元字符或不区分大小写的字母元字符
 * []{n} 代表前元字符有n个
 * []{n,} 代表前元字符有n或者n以上个数
 * []{n,m} 代表前元字符有n到m个数(可以包含n，m)
 */
public class RegexDemo {

    public static void demo(String source, String regex) {
        if (source.matches(regex)) {
            System.out.println("正确匹配");
        } else {
            System.out.println("错误匹配");
        }
    }

    public static void main(String[] args) {
        String reg = "[0-9]{17}[0-9xX]";
        String math = "360121199101087563";
        String hh = "36012119910108753X";
        demo(math, reg);
        demo(hh, reg);
    }
}
