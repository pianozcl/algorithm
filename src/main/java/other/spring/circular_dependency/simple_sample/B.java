package other.spring.circular_dependency.simple_sample;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  3:13 AM
 * @description:
 **/
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void print() {
        System.out.println("b");
    }
}
