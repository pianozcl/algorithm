package array;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;

/**
 * @author : chenliangzhou
 * create at:  2021/8/4  2:56 PM
 * @description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 **/
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add((nums2[i]));
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            arr[i++] = re;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(JSON.toJSONString(intersection));
    }

}
