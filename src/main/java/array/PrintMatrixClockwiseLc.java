package array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/1/7  12:52 PM
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 1， 2， 3， 4
 * 5， 6， 7， 8
 * 9， 10，11，12
 * 13，14，15，16
 * <p>
 * 1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 **/
public class PrintMatrixClockwiseLc {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length < 1) {
            return new int[]{};
        }
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> list = new ArrayList();
        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
