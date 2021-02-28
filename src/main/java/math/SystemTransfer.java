package math;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/2/25  7:25 PM
 * @description: 进制转换
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 **/
public class SystemTransfer {

    public String solve (int M, int N) {
        // write code here
        StringBuilder builder = new StringBuilder();

        //当M为负数时，还以正数来计算，根据flag在返回结果上加符号
        boolean flag = true;
        if (M < 0) {
            flag = false;
            M = -M;
        }

        String hex = "0123456789ABCDEF";
        while (M != 0) {
            builder.append(hex.charAt(M % N));
            M = M / N;
        }
        return flag ? builder.reverse().toString() : "-".concat(builder.reverse().toString());
    }

    public static void main(String[] args) {
        String solve = new SystemTransfer().solve(-7, 3);   //-21
        System.out.println(solve);
    }
}
