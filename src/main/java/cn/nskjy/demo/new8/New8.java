package cn.nskjy.demo.new8;

import org.apache.poi.ss.formula.functions.T;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 新特性 lambda表达式不能函数式接口的非抽象方法
 */
public interface New8<T> {

    void new8(T t);

    default New8<T> reString(New8<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {new8(t); after.new8(t);};
    }

    static void main(String[] args) {
        New8<String> new8 = t -> System.out.println(t + "New8");
        new8.new8("调用了");

//        Predicate<New2> predicate = (new2) -> new2.equals(new Lambda7());
//        boolean test = predicate.test(new New2());
//        Predicate<New2> and = predicate.and((Predicate<? super New2>) new New2());
//        System.out.println(test);
//        New8 lambdaa = () -> System.out.println("lambda表达式");
//        System.out.println("*********");
//        lambdaa.new8();
//        System.out.println(lambdaa.reString("str"));
//        Consumer<T>
    }
}
