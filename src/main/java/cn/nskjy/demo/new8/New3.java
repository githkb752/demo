package cn.nskjy.demo.new8;

/**
 * 函数式接口(只有一个抽象方法,可以有多个默认非抽象方法)
 */
@FunctionalInterface
public interface New3<F, T> {
    F convert(T from);

    static void main(String[] args) {
        New3<Integer, String> new3 = (from) -> Integer.valueOf(from);
        System.out.println(new3.convert("111"));
    }

}
