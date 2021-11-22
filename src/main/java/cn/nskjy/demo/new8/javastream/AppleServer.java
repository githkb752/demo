package cn.nskjy.demo.new8.javastream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleServer {

    private static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple(1, "red", 500, "湖南"));
        appleStore.add(new Apple(2, "red", 300, "北京"));
        appleStore.add(new Apple(3, "green", 200, "湖南"));
        appleStore.add(new Apple(4, "green", 500, "湖南"));
    }

    public void test02() {
        appleStore.stream()
                .peek(v -> System.out.println(v.getColor()))
                .peek(v -> System.out.println(v.getWeight()))
                .toArray();
    }


    public void test01() {
        appleStore.stream()
                .collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingDouble(Apple::getWeight)))
                .forEach((k,v) -> System.out.println(k + ":" + v));
    }

    public void test(Predicate<? super Apple> pre) {
        // 1.挑选苹果为红色
        List<Apple> apples = appleStore.stream()
                .filter(pre)
                .collect(Collectors.toList());
        System.out.println(apples);
    }

    public static void main(String[] args) {
        new AppleServer().test02();
    }
}
