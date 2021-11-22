package cn.nskjy.demo.design.fectory;

public class GreekPizz extends Pizz {

    @Override
    void prepare() {
        System.out.println("GreekPizz: is preparing");
    }

    public static void main(String[] args) {
        Pizz pizz = new GreekPizz();
        pizz.setName("GreekPizz");
        pizz.prepare();
        pizz.bake();
        pizz.cut();
        pizz.box();
    }
}
