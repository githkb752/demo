package cn.nskjy.demo.new8.demo2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompartorTest {

    List<Employee> emps = Arrays.asList(
            new Employee("小三", 25, 11000),
            new Employee("李忠利", 25, 8888),
            new Employee("张大中",32, 15000),
            new Employee("黄大全", 32,20000),
            new Employee("李向前", 24, 5000));
    
    @Test
    public void test01() {
        Collections.sort(emps, (emp1, emp2) -> {
            if (emp1.getAge() == emp2.getAge()) {
                return emp1.getName().compareTo(emp2.getName());
            } else {
                return Integer.compare(emp1.getAge(),emp2.getAge());
            }
        });
        System.out.println(emps);
    }

    @Test
    public void test02() {
        Collections.sort(emps, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
        Collections.sort(emps,Comparator.comparing(Employee::getName));
        System.out.println(emps);
    }

    @Test
    public void test03() {
        List<String> list = Arrays.asList("张","c", "bbcc", "ddd");
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);
    }
}
