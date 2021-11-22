package cn.nskjy.demo.new8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * java8新特新-创建stream流四种方式
 */
public class CreateStream {

    List<Employee> emps = Arrays.asList(
            new Employee("小三", 25, 11000),
            new Employee("李忠利", 28, 8888),
            new Employee("张大中",35, 15000),
            new Employee("黄大全", 32,20000),
            new Employee("李向前", 24, 5000));

    @Test
    public void test01() {
        // 1.集合数组数据源创建stream流
        List<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(24);
        list.add(23);
        list.add(26);
        list.add(27);
        Stream<Employee> stream = emps.stream();
        stream.map(Employee::getAge)
                .filter(age -> age > 25)
                .forEach(System.out::println);

        // 2.数组数据源创建Stream流
        String[] str = new String[2];
        Stream<String> stream1 = Arrays.stream(str);
        long count = stream1.count();
        System.out.println(count);

        // 3.Stream流的静态方法of()创建stream流
        Stream<Employee> of = Stream.of();
        of.map(emp->emp.getAge())
                .filter(age-> age > 25)
                .forEach(System.out::println);

        // 4.Stream流的迭代器创建无限流
        Stream<Double> iterate = Stream.iterate(0.0, a -> Math.random()*100);
        iterate.filter(b -> b > 1.0)
                .limit(2)
                .forEach(System.out::println);

        // Stream流通过生成器创建无限流
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.filter(a -> a > 0.1)
                .limit(2)
                .forEach(System.out::println);
    }

}
