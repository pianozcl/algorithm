package array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/7  12:52 PM
 * @description: 顺时针打印矩阵
 * <p>
 * 1， 2， 3， 4
 * 5， 6， 7， 8
 * 9， 10，11，12
 * 13，14，15，16
 * <p>
 * 1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 **/
public class PrintMatrixClockwise {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int left = 0, top = 0;
        int right = matrix[0].length-1, bottom = matrix.length-1;

        ArrayList<Integer> list = new ArrayList<>();

        //从整体看，当top边界 > bottom，或者 right > left的时候，应该break跳出循环
        while (true) {
            //遍历top所在的行，遍历完了，top边界加1 （top边界坐标从0开始）
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }

            //遍历right边界所在列，遍历完了，right边界减1
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left > --right) {
                break;
            }

            //遍历bottom边界所在行，遍历完了，bottom边界加1
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }

            //遍历left边界所在列，遍历完了，left边界加1
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        /**
         * 1,2,3
         * 4,5,6
         * 7,8,9
         */
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(JSON.toJSONString(list));
    }
}
