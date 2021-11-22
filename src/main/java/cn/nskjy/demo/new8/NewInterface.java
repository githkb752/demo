package cn.nskjy.demo.new8;

/**
 * java8新特性一，可以有default修饰的非抽象方法
 */
public interface NewInterface {
    void calculate(int a);


    default double sss(int a) {
        return Math.sqrt(a);
    }

    static void main(String[] args) {
        NewInterface newInterface = new NewInterface() {
            @Override
            public void calculate(int a) {
            }
        };
        System.out.println(newInterface.sss(100));
    }


}
