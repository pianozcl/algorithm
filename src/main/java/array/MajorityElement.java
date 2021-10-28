package array;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  3:44 PM
 * @description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 **/
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,2,1,6,6,6,3};
        int i = majorityElement2(arr);
        System.out.println(i);
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        int vote = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                res = nums[i];
            }
            if (res == nums[i]) {
                vote++;
            } else {
                vote--;
            }
        }
        return res;
    }
}
