package math;

import java.util.Arrays;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  10:38 PM
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 **/
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length/2]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[array.length / 2];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        int i = moreThanHalfNum.MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }
}
