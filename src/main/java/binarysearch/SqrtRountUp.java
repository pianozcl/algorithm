package binarysearch;

/**
 * @author : chenliangzhou
 * create at:  2021/2/6  10:57 PM
 * @description: 实现函数 int sqrt(int x). 计算并返回x的平方根（向下取整）
 **/
public class SqrtRountUp {
    public static int sqrt (int x) {
        // write code here
        int l = 0;
        int r = x;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (x >= mid * mid) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(500));
    }
}
