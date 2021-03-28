package other;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {


        int mask = 1;
        int count = 0;
        int value = -1;
        for (int i = 0; i < 32; i++) {
            if ((value & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }

        System.out.println(Integer.toBinaryString(100));
        System.out.println(count);
    }
}
