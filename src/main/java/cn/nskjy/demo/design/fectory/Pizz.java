package cn.nskjy.demo.design.fectory;

public abstract class Pizz {

    protected String name;

    abstract void prepare();

    public void bake(){
        System.out.println(name + ": baking");
    }

    public void cut() {
        System.out.println(name + ": cutting");
    }

    public void box() {
        System.out.println(name + ": boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}
