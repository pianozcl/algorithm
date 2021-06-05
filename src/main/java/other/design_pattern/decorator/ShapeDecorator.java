package other.design_pattern.decorator;

/**
 * @author : chenliangzhou
 * create at:  2021/6/2  11:30 AM
 * @description:
 **/
public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
