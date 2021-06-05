package dp;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/6/3  11:35 AM
 * @description: 64. 最小路径和 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 **/
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int sum = 0;

        //第一行和第一列的最小路径是确定的，先进行计算
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            dp[0][j] = sum;
        }

        //从第二行第二列开始，当前网格的最小路径，等于当前网格左边网格的最小路径，和当前上边网格的最小路径，两者最小的加上当前网格value
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        System.out.println(JSON.toJSONString(dp));
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(arr);
        System.out.println(i);
    }
}

