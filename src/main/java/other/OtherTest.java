package other;

import basestructure.ListNode;
import basestructure.TreeNode;
import binarytree.LevelOrder;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class OtherTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(JSON.toJSONString(permute));
     }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
            return list;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recur(nums, list, path, 0, used);
        return list;
    }
    public static void recur(int[] arr, List<List<Integer>> list, List<Integer> path, int level, boolean[] used) {
        if (level == arr.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                path.add(arr[i]);
                used[i] = true;
                recur(arr, list, path, level + 1, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
}
