package other.design_pattern.singleton;

/**
 * @author : chenliangzhou
 * create at:  2021/3/31  11:20 PM
 * @description: 懒汉式
 **/
public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            new Thread(()-> System.out.println(LazySingleton.getInstance().hashCode())).start();
        }
    }
}
