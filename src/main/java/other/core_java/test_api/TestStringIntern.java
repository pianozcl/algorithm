package other.core_java.test_api;

/**
 * @author : chenliangzhou
 * create at:  2021/2/22  11:44 PM
 * @description: 使用 String.intern() 可以保证相同内容的字符串变量引用同一的内存对象
 **/
public class TestStringIntern {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);

        String s3 = s1.intern();
        System.out.println(s3 == s1.intern());
    }
}
