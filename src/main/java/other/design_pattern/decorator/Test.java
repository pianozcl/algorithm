package other.design_pattern.decorator;

/**
 * @author : chenliangzhou
 * create at:  2021/6/2  11:33 AM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        Shape circle = new Circle();
        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        System.out.println("normal circle");
        circle.draw();
        System.out.println("----------------");
        System.out.println("circle with red border");
        redCircle.draw();
    }
}
