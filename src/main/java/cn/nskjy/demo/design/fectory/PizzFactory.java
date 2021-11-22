package cn.nskjy.demo.design.fectory;

public class PizzFactory {

    public static Pizz createPizz(String pizzName) {
        Pizz pizz = null;
        if ("GreekPizz".equals(pizzName)) {
            pizz = new GreekPizz();
            pizz.setName("北京的奶酪");
            return pizz;
        }
        return null;
    }
}
