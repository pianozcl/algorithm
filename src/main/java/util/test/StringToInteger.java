package util.test;

/**
 * @author : chenliangzhou
 * create at:  2021/2/25  5:30 PM
 * @description: 测试类型转换性能
 **/
public class StringToInteger {
    public static void main(String[] args) {
        String s = "1.0";

        String[] split = s.split("\\.");
        System.out.println(split[0]);

        double v = Double.parseDouble(s);
        System.out.println(v);

    }
}
