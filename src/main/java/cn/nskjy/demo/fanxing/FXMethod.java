package cn.nskjy.demo.fanxing;

/**
 * 泛型：类型参数化
 */
public class FXMethod {

    public static <T> String fxMethod(T t) {
        if (t instanceof Integer) {
            System.out.println("T为整数型");
        }
        return "我是泛型方法";
    }

    public static void main(String[] args) {
        Integer str = 1;
        System.out.println(fxMethod(str));
    }

}
