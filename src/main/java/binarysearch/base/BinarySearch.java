package binarysearch.base;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  3:48 PM
 * @description: 二分搜索
 **/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
