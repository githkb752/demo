package cn.nskjy.demo.new8.demo1;

import org.junit.Test;

import java.util.*;

/**
 * 设计模式之策略模式：需要什么参数就传什么参数
 */
public class FilterEmp {

    List<Employee> emps = Arrays.asList(
            new Employee("小三", 25, 11000),
            new Employee("李忠利", 28, 8888),
            new Employee("张大中",35, 15000),
            new Employee("黄大全", 32,20000),
            new Employee("李向前", 24, 5000));

    @Test
    public void filterEmp() {

        // 选出年龄大于26岁的员工
        List<Employee> employees = new ArrayList<>();
        for (Employee emp : emps) {
            if (emp.getAge() > 26) // 抽象层
                employees.add(emp);
        }
        System.out.println(employees);

        // 选出月薪高于9999的员工
        List<Employee> empList = new ArrayList<>();
        for (Employee emp : emps) {
            if (emp.getSalary() > 9999) // 抽象层
                empList.add(emp);
        }
        System.out.println(empList);
    }

    // 公共层(接口式编程的实现)
    List<Employee> getEmps(List<Employee> emps, Lambda01<Employee, Object> lambda01, Object o) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : emps) {
            if (lambda01.check(employee, o)) {
                employees.add(employee);
            }
        }
        return employees;

    }

    @Test
    public void test01() {
        // 选出员工年龄大于26的员工
//        List<Employee> employees = getEmps(emps, (Employee e, Object o) -> e.getAge() > (int) o, 26);
//        System.out.println(employees);
        // 选出员工月薪高于9999的员工
        List<Employee> emps1 = getEmps(emps, (emp,  o) -> emp.getSalary() > (double) o, 9999.0);
        System.out.println(emps1);
    }

    @Test
    public void test02() {
        emps.stream()
                .filter(e -> e.getSalary() > 9999)
                .limit(2)
                .forEach(System.out::println);

        emps.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);
    }

    @Test
    public void test03() {

        System.out.println("我执行了");
        if (true) {
            return;
        }
        System.out.println("我执行了没");
    }


}
