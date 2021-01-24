package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  9:21 PM
 * @description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 **/
public class GetUglyNumber {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {

            //从小到大，丑数必然在这n2, n3, n5其中。先选最小的
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);

            //这里if不一定命中，但不影响
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[index - 1];
    }

}
