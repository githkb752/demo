package cn.nskjy.demo.principle.ocp.improve;

public class Ocp {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        Shap shap = new Rectangle();
        graphicEditor.draw(shap);
        System.out.println(shap.m_type);
        new GraphicEditor().draw(new Circle());
        new GraphicEditor().draw(new Triangle());
    }
}

class GraphicEditor{
    public void draw(Shap shap) {
        shap.draw();
    }
}

abstract class Shap{
    int m_type;

    void draw() {

    }
}


class Rectangle extends Shap{
    Rectangle() { this.m_type = 1; }
    @Override
    public void draw() {
        System.out.println("使用矩形绘图");
    }
}

class Circle extends Shap{

    Circle() {this.m_type = 2; }

    @Override
    public void draw() {
        System.out.println("使用圆形绘图");
    }
}

class Triangle extends Shap{

    Triangle() {this.m_type = 3;}

    @Override
    public void draw() {
        System.out.println("使用三角形绘图");
    }
}