package cn.nskjy.demo.new8;

/**
 * java8新特性 7：访问对象的变量和静态变量
 */
public class Lambda7 {

    static int age;

    int num;

    void testScope() {
        Convert6<String, Integer> convert6 = (from) -> {
            age = 29;
            return age;
        };
        convert6.convert("");
        Convert6<String, Integer> convert = (from) -> {
            num = 30;
            return num;
        };
        System.out.println(convert.convert(""));
    }

    public static void main(String[] args) {
        Lambda7 lambda7 = new Lambda7();
        lambda7.testScope();
    }
}
