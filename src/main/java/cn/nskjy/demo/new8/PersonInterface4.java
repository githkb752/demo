package cn.nskjy.demo.new8;

/**
 * java8新特性 :: 关键字 构造函数的引用
 */
public interface PersonInterface4<P extends Person4> {

    P createPerson(String preName, String tailName);

    static void main(String[] args) {
        PersonInterface4<Person4> person = Person4::new;
        Person4 person4 = person.createPerson("perter", "wang");
        System.out.println(person4);
    }

}
