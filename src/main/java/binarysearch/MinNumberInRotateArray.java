package binarysearch;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  9:53 PM
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * [3,4,5,1,2]
 * 1
 **/
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (array[m] > array[r]) {
                l = m + 1;
            } else if (array[m] < array[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return array[l];
    }
}
