package math;

/**
 * @author : chenliangzhou
 * create at:  2021/4/11  11:40 PM
 * @description: 圆圈中最后剩下的数字
 *
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 *
 *
 * 递归求解, 要求n m，先求n-1,m  如下画图找关系
 *
 * 例如 0，1，2，3，4      n=5 m=3      结果为3
 *
 * 求n - 1      0，1，2，3                     n=4 m=3       结果为 x = 0
 *
 *
 * 3 = （3 + 0）% 5 = 3
 **/
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }
}
