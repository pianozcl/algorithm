package other.core_java.test_api;

/**
 * @author : chenliangzhou
 * create at:  2021/2/26  4:03 PM
 * @description: 测试字符串
 **/
public class TestString {
    public static void main(String[] args) {
        String s = "{\"name\" :\"qqqq\"}";
        String s1 = "{\"name\" : \"qqqq\"}";
        System.out.println(s.length());
        System.out.println(s1.length());

        String s2 = "1,2,3,";

        String[] split = s2.split(",");
        System.out.println(split.length);
        for (String s3 : split) {
            System.out.println(s3);
        }
    }
}
