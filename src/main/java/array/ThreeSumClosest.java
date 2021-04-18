package array;

import java.util.Arrays;

/**
 * @author : chenliangzhou
 * create at:  2021/4/14  4:08 PM
 * @description: 16. 最接近的三数之和
 *
 *示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 **/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int abs = 0x7fffffff;
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (Math.abs(nums[l] + nums[r] + one - target) < abs) {
                    abs = Math.abs(nums[l] + nums[r] + one - target);
                    closest = nums[l] + nums[r] + one;
                }
                if (nums[l] + nums[r] + one < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,-4};
        int i = new ThreeSumClosest().threeSumClosest(arr, 1);
        System.out.println(i);
    }
}
