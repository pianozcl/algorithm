package graph;

/**
 * @author : chenliangzhou
 * create at:  2021/3/2  12:15 AM
 * @description: 岛屿数量
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 **/
public class NumsIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int colLen = grid.length;
        int rowLen = grid[0].length;
        int num = 0;
        for (int r = 0; r < colLen; r++) {
            for (int c = 0; c < rowLen; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int r, int c) {
        //base case当坐标不在二维数组返回
        if (!inArea(grid, r, c)) {
            return;
        }

        //当坐标不为1时候返回
        if (grid[r][c] != '1') {
            return;
        }

        //遍历过后将1改为0，避调用函数死循环stackoverflow
        grid[r][c] = '0';

        //上下左右
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);


    }

    public boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) {
        int i = new NumsIslands().numIslands(new char[][]{{'1', '0', '1', '1', '0', '1', '1'}});
        System.out.println(i);
    }
}
