package cn.nskjy.demo.reflect;

import java.lang.reflect.Method;

public class Demo {
    public static int flooer = 1000 * 1000 * 1000;

    public static void main(String[] args) {
        t1();
        t2();
        t3();
    }

    public static void t1() {
        long s = System.currentTimeMillis();
        for (int i = 0; i < flooer; i++) {
            Person person = new Person();
            person.setAge(30);
        }
        long e = System.currentTimeMillis();
        System.out.println("创建10亿对象并赋值耗时：" + (e - s));
    }

    public static void t2() {
        long s = System.currentTimeMillis();
        Person person = new Person();
        for (int i = 0; i < flooer; i++) {
            person.setAge(30);
        }
        long e = System.currentTimeMillis();
        System.out.println("给10亿对象赋值耗时：" + (e - s));
    }

    public static void t3() {
        long s = System.currentTimeMillis();
        Class<Person> person = Person.class;
        try {
            Person p = person.newInstance();
            Method m = person.getMethod("setAge", Integer.class);
            for (int i = 0; i < flooer; i++){
                m.invoke(p,30);
            }
            long e = System.currentTimeMillis();
            System.out.println("利用反射创建10亿对象并赋值：" + (e - s));
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }


    static class Person {
        private int age = 10;

        public int getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
