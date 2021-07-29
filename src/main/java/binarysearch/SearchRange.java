package binarysearch;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/7/27  1:55 PM
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 **/
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int i = mid, j = mid;
                while (i > 0) {
                    if (nums[i - 1] == nums[i]) {
                        i--;
                    } else {
                        break;
                    }
                }
                while (j < nums.length - 1) {
                    if (nums[j + 1] == nums[j]) {
                        j++;
                    } else {
                        break;
                    }
                }
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        int[] ints = searchRange(arr, 8);
        System.out.println(JSON.toJSONString(ints));
    }
}
