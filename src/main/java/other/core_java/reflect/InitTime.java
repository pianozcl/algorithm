package other.core_java.reflect;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  2:01 PM
 * @description: 初始化时机
 **/
public class InitTime {
    static {
        System.out.println("MAIN");
    }

    public static void main(String[] args) {
        System.out.println(Son.M);        //常量不会导致类初始化，因为在类加载的链接阶段，常量就存入常量池了

    }
}


class Father {
    static int b;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static int m = 100;     //静态变量，静态代码快初始化时机，跟代码顺序有关
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static final int M = 1;
}
