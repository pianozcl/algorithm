package array;

import java.util.HashMap;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  5:05 PM
 * @description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int[] ints = twoSumByMap(arr, 9);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum (int[] numbers, int target) {
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumByMap (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
    }
}
