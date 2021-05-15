package other.spring.circular_dependency.simple_sample;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  3:13 AM
 * @description:
 **/
public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void print() {
        System.out.println("a");
    }
}
