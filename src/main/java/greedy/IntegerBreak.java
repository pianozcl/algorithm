package greedy;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  5:23 PM
 * @description: Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 **/
public class IntegerBreak {
    /**
     * 拆分成2，和3最大
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        double num = n/3;
        double m = 3.0;
        if (n % 3 == 0) {
            return (int)Math.pow(m, num);
        } else if (n % 3 == 1) {
            return (int)Math.pow(m, num - 1) * 4;
        } else {
            return(int) Math.pow(m, num) * 2;
        }
    }
}
