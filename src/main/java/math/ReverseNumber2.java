package math;

/**
 * @author : chenliangzhou
 * create at:  2021/7/26  12:13 AM
 * @description: 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 **/
public class ReverseNumber2 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int mod = x % 10;
            x /= 10;
            res = res * 10 + mod;
        }
        return res;
    }
}
