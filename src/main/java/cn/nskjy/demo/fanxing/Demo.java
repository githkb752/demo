package cn.nskjy.demo.fanxing;

import java.util.ArrayList;

/**
 * 通过以下例子，证明泛型解决什么问题而产生
 * 在编译解决将不同类型的数据存放在一个集合中
 */
public class Demo {
    public static void demo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("我是一个泛型");
        arrayList.add(1111);
        for (int i = 0; i < arrayList.size(); i++) {
            String o = (String)arrayList.get(i);
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        int i = 1;
        String s = String.valueOf(i);
        System.out.println(s);
        demo();
    }
}
