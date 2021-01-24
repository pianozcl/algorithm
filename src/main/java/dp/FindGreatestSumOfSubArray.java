package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/1/23  4:22 PM
 * @description: 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * [1,-2,3,10,-4,7,2,-5]
 * 18
 **/
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
