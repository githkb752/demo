package cn.nskjy.demo.new8;

/**
 * java8新特性 :: 关键字
 */
public interface New4<T, F> {

    T convert(F from);

    static void main(String[] args) {
        New4<SomeThing4, String> new4 = SomeThing4::startWith;
        System.out.println(new4.convert("str"));

        SomeThing4 someThing4 = new SomeThing4();
        New3<String, String> endWith = someThing4::endWith;
        System.out.println(endWith.convert("endWith"));

        New4<SomeThing4, String> new41 = SomeThing4::new;
        SomeThing4 someThing41 = new41.convert("someThing41");
        System.out.println(someThing41);
    }
}
