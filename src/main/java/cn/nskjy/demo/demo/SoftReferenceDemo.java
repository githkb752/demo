package cn.nskjy.demo.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference<TakeOutFood> softReference = new SoftReference(new TakeOutFood());
        WeakReference<TakeOutFood> weakReference = new WeakReference<>(new TakeOutFood());

        TakeOutFood takeOutFood = softReference.get();
        TakeOutFood food = weakReference.get();
        takeOutFood.setPlatform("饿了吗");
        takeOutFood.setSeller("天虹商场周黑鸭");
        takeOutFood.setFoodName("鸭头");
        System.out.println(takeOutFood);
    }
}
