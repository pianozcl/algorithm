package dp;

/**
 * @author : chenliangzhou
 * create at:  2020/10/10  3:50 PM
 * @description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。  一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。  若这两个字符串没有公共子序列，则返回 0
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 **/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int i = longestCommonSubsequenceDP("abcde", "ace");
        System.out.println(i);
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        return dp(text1,text2,text1.length()-1,text2.length()-1);
    }

    //暴力递归版
    public static int dp(String text1, String text2,int i,int j){
        if(i==-1 || j==-1){
            return 0;
        }
        if(text1.indexOf(i)==text2.indexOf(j)){
            return dp(text1,text2,i-1,j-1)+1;
        }else {
            return Math.max(dp(text1,text2,(i-1),j),dp(text1,text2,i,(j-1)));
        }
    }


    /**
     * 动态规划，构造DP table。自底向上求解，求出二维dp表每个元素的最长子串，后面的解依赖前面的
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }

}
