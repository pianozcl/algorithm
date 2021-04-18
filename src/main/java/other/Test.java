package other;

import basestructure.TreeLinkNode;
import basestructure.TreeNode;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MAX_VALUE % 10);
    }


    public static int sub(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }











    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
