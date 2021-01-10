package twopointers;

import java.util.ArrayList;

/**
 * @author : chenliangzhou
 * create at:  2021/1/10  12:34 PM
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * [1,2,4,7,11,15],15
 * [4,11]
 **/
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        int p1 = 0, p2 = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 < p2) {
            if (array[p1] + array[p2] == sum) {
                list.add(array[p1]);
                list.add(array[p2]);
                break;
            } else if (array[p1] + array[p2] < sum) {
                p1++;
            } else {
                p2--;
            }
        }
        return list;
    }
}
