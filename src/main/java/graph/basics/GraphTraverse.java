package graph.basics;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/3/1  3:25 PM
 * @description: 图算法框架
 **/
public class GraphTraverse {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        dfs(arr, 0, 0);
        System.out.println(JSON.toJSONString(arr));
    }

    static void dfs(int[][] grid, int r, int c) {
        // 判断 base case
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if (!inArea(grid, r, c)) {
            return;
        }

        if (grid[r][c] != 1) {
            return;
        }

        // 如果这个格子不是岛屿，直接返回
        grid[r][c] = 2;

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    static boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
