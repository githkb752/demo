package cn.nskjy.demo.new8.demo3;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda表达式常用四大接口
 * Consumer: 消费型接口
 *  void accept(T t)
 * Supplier: 供给型接口
 *  T get()
 * Function: 函数型接口
 *  T apply(F f)
 * Predicate: 断言型接口
 *  boolean test(T t)
 */
public class Java8Often {

    // 函数式接口四：断言型
    @Test
    public void test04() {
        List<String> lists = Arrays.asList("aa","bbbb", "ccc", "ddddd");
        List<String> predicate = predicate(lists, str -> str.length() > 3);
        System.out.println(predicate);

    }

    // Predicate
    public List<String> predicate(List<String> list, Predicate<String> predicate) {
        List<String> strings = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)) {
                strings.add(str);
            }
        }
        return strings;
    }

    // 函数式接口三：function
    @Test
    public void test03() {
        String string = function("abcdd", str -> str.toUpperCase());
        System.out.println(string);

        String function = function("   我在", str -> str.trim());
        System.out.println(function);
    }

    // Function
    public String function(String str, Function<String, String> function) {
        return function.apply(str);
    }


    /**
     * 函数式接口二：供给型
     */
    @Test
    public void test02() {
        List<Integer> supplier = supplier(5, () -> (int)(Math.random()*100));
        System.out.println(supplier);
    }

    // Supplier
    public List<Integer> supplier(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer random = supplier.get();
            list.add(random);
        }
        return list;
    }

    // 常用函数式接口一
    @Test
    public void test01() {
        consumer(5000.0, d -> System.out.println("本次购买用品花费：" + d + "元"));
    }

    // Consumer
    public void consumer(double d, Consumer<Double> consumer) {
        consumer.accept(d);
    }
}
