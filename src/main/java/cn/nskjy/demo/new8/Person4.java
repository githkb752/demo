package cn.nskjy.demo.new8;

/**
 * java8新特性 :: 关键字 构造函数引用
 */
public class Person4 {
    String preName;

    String tailName;

    Person4(){}

    Person4(String preName, String tailName) {
        this.preName = preName;
        this.tailName = tailName;
    }

    @Override
    public String toString() {
        return "Person4{" +
                "preName='" + preName + '\'' +
                ", tailName='" + tailName + '\'' +
                '}';
    }
}
