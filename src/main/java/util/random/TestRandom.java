package util.random;

import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/2/13  8:59 PM
 * @description: 随机数
 **/
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.println(random.nextInt(1000));
        }
    }
}
