package other.design_pattern.decorator;

/**
 * @author : chenliangzhou
 * create at:  2021/6/2  11:29 AM
 * @description:
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape:circle");
    }
}
