package queue;

import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/7/27  10:47 AM
 * @description: 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 **/
public class FindKthLargestWithPriorityQueue {

    /**
     * 维护一个长度为k的小跟堆。数组元素入堆。最后弹出堆顶元素即为第k大
     * @author zhouchenliang
     * @date 10:48 AM 2021/7/27
     * @param
     * @return
     * @throws
     **/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
