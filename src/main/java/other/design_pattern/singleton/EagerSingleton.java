package other.design_pattern.singleton;

/**
 * @author : chenliangzhou
 * create at:  2021/3/31  11:17 PM
 * @description: 饿汉式
 **/
public class EagerSingleton {
    //线程安全，但是一定会初始化
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    //私有构造方法
    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
