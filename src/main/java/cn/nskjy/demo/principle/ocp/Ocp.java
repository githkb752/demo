package cn.nskjy.demo.principle.ocp;

public class Ocp {
    public static void main(String[] args) {
        new GraphicEditor().draw(new Rectangle());
        new GraphicEditor().draw(new Circle());
    }
}

/**
 * 形状
 */
class Shap{
    int m_type;
}


/**
 * 使用形状绘图(适用方)
 */
class GraphicEditor{
    public void draw(Shap shap) {
        if (shap.m_type == 1) {
            drawRectangle(shap);
        }else if (shap.m_type == 2) {
            drawCircle(shap);
        }
    }

    public void drawRectangle(Shap shap){
        System.out.println("使用矩形绘画");
    }

    public void drawCircle(Shap shap) {
        System.out.println("使用圆形绘画");
    }
}

/**
 * 矩形
 */
class Rectangle extends Shap{
    Rectangle(){this.m_type = 1;}
}

/**
 * 圆形
 */
class Circle extends Shap{
    Circle(){this.m_type = 2;}
}

class Triangle extends Shap {
    Triangle () {this.m_type = 3;}
}