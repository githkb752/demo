package cn.nskjy.demo.new8;

/**
 * java8 新特性 5：lambda作用域
 * 6: lambda表达式访问局部变量
 */
public interface Convert6<F, T> {

    String str = "from";

    T convert(F from);

    static void main(String[] args) {
        Convert6<String, String> convert6 = (from) -> {
            return null;
        };
        String convert = convert6.convert("666");
        System.out.println(convert);
//        Convert6<String, String> convert6 = new Convert6<String, String>() {
//            public String convert(String from) {
//                return str + from;
//            }
//        };
//        System.out.println(convert6.convert("666"));
    }
}
