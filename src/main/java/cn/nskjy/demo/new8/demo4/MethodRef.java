package cn.nskjy.demo.new8.demo4;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 方法引用：
 * 构造器引用：
 * 数组引用：
 */
public class MethodRef {
    List<Employee> emps = Arrays.asList(
            new Employee("小三", 25, 11000),
            new Employee("李忠利", 28, 8888),
            new Employee("张大中",25, 15000),
            new Employee("黄大全", 32,20000),
            new Employee("李向前", 28, 5000));

    @Test
    public void test03() {
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        set.add("eee");
        List<String> list = new ArrayList<>(set);
        System.out.println(list.get(0));
//        BiFunction<Long, Long, Long> biFunction = Math::multiplyExact;
//        long apply = biFunction.apply(10L, 10L);
//        System.out.println(apply);

    }

    @Test
    public void test02() {
        Function<String, String> function = String::trim;
        String s = "22222222222";
        BiFunction<Integer, Integer, String> function1 = s::substring;
        String aaa = function.apply("\t\t\t  aaa");
        String apply = function1.apply(2, 4);
        System.out.println(apply);
        System.out.println(aaa);
    }

    @Test
    public void test01() {
        Collections.sort(emps,(emp1, emp2) ->{
            if (emp1.getAge() == emp2.getAge())
                return emp1.getName().compareTo(emp2.getName());
            else
                return Integer.compare(emp1.getAge(), emp2.getAge());
        });
        System.out.println(emps);
    }
}
