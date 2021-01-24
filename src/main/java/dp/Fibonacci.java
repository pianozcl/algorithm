package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  11:22 AM
 * @description:
 **/
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prepre = 0, pre = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return curr;
    }
}
