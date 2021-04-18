package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/14  9:45 AM
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) {
            return list;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        recur(nums, list, path, 0, used);
        return list;

    }

    public void recur(int[] arr, List<List<Integer>> list, List<Integer> path, int level, boolean[] used) {
        if (level == arr.length) {
            list.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {     //去重，
                path.add(arr[i]);
                used[i] = true;     //把当前i置为true，例如[1,2,3]，当前为1，那么下一层只能为2或者3，否则会出现重复
                recur(arr, list, path, level + 1, used);
                used[i] = false;    //当前元素递结束，回溯的过程中，要把used再置为false。最顶层递归的for循环走到2，再向下递归
                path.remove(path.size() - 1);   //回溯到过程，还要删除path
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
