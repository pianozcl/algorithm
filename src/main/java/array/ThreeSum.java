package array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/3/11  4:11 PM
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。  注意：答案中不可以包含重复的三元组
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);      // -4, -1, -1, 0, 1, 2
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //去重错误的写法，例如-4, -1, -1, 0, 1, 2，必须从第一个-1开始。不能从第二个-1开始，那样就会丢失[-1,-1,2]这个组合
//            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
//                continue;
//            }
            int l = i + 1, r = nums.length - 1;
            int one = nums[i];
            while (l < r) {
                //如果two + three = -one，则记录当前三个数。由于从小到达排过序，不等于则移动左或者右指针
                if (nums[l] + nums[r] < -one) {
                    l++;
                } else if (nums[l] + nums[r] > -one) {
                    r--;
                } else {
                    ArrayList<Integer> sub = new ArrayList<>();
                    sub.add(one);
                    sub.add(nums[l]);
                    sub.add(nums[r]);
                    list.add(sub);

                    l++;
                    //判断当前one下标后面，是否还有两个数相加等于 -one的值，l++是为了去重复
                    // 假如l和前一个l相同，说明two，和three也和前一个相同（重复）。所以while里面l++去重
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new ThreeSum().threeSum(arr);

        System.out.println(JSON.toJSONString(lists));
    }
}
