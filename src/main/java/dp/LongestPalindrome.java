package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/2/1  11:58 PM
 * @description: 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。  给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * "abc1234321ab",12
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int max = 1;    //记录最大长度
        int begin = 0;  //记录最大回文子串的起始下标
        boolean[][] dp = new boolean[len][len];

        //i，j代表回文串的左右边界下标，dptable代表子串i ~ j是否为回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;    //对角线为单个字符，一定是回文
        }

        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) { //如果 i j下标的字符不一样，则 i~j一定不是回文子串
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {        // else i j字符相等的情况、假如j - i < 3,  那i j之间最多就一个字符，一定是回文
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];    //i j下标元素相同，且j - i >= 3的情况，需要判断[i + 1][j - 1]是否为true
                                                        //因为整个二维的dp table是先从上往下，再从左到有遍历，所以[i + 1][j - 1]之前已经计算好了
                    }
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }


    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (n == 0 || n == 1) {
            return n;
        }
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (A.charAt(i) != A.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String asddse = new LongestPalindrome().longestPalindrome("asddse");
        System.out.println(asddse);
    }

}

