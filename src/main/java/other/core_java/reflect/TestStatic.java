package other.core_java.reflect;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  12:04 PM
 * @description: 静态
 **/
public class TestStatic {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m); //100
    }
}

class A {
    static int m = 100;

    static {
        System.out.println("A静态代码块");
        m = 300;
    }

    public A() {
        System.out.println("无参构造方法");
    }
}
