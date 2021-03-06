package dp;

/**
 * @author : chenliangzhou
 * create at:  2020/10/9  3:49 PM
 * @description: 给定两个字符串str1和str2, 输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * 输入："1AB2345CD","12345EF"
 * 输出："2345"
 **/
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD", "12345EF"));
        String[] str = new String[3];
        System.out.println("qweqweqwe".substring(0, 9));
    }

    public static int lcs(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {     //这里不需要判断不等的情况，因为dp初始化为0，假如不等，不做任何处理从0开始重新计算
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }

    public static String LCS(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        int max = 0, index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (max < dp[i + 1][j + 1]) {
                        max = dp[i + 1][j + 1];
                        index = i + 1;
                    }
                }
            }
        }
        return max == 0 ? "-1" : str1.substring(index-max,index);
    }
}
