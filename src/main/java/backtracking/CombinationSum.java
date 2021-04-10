package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/8  4:50 PM
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。  candidates 中的数字可以无限制重复被选取
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 **/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates.length == 0) {
            return list;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, candidates.length, target, path, list);
        return list;
    }

    void dfs(int[] arr, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        //每一次搜索的时候设置 下一轮搜索的起点 begin，避免重复结果
        for (int i = begin; i < len; i++) {
            path.addLast(arr[i]);
            dfs(arr, i, len, target - arr[i], path, res);

            //到达树的最后一层，递归函数返回，此时queue队列通过removeLast，回溯到树到上一层的状态
            path.removeLast();
        }
    }
}
