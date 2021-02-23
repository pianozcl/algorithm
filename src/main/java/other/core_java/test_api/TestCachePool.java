package other.core_java.test_api;

/**
 * @author : chenliangzhou
 * create at:  2021/2/22  11:32 PM
 * @description: 测试缓存池
 **/
public class TestCachePool {
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y); //false

        int i = Integer.valueOf(123);
        int j = Integer.valueOf(123);
        System.out.println(i == j); //valueOf会从缓存池取，true
    }
}
