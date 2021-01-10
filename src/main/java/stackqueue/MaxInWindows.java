package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  11:37 PM
 * @description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 输入
 * [2,3,4,2,6,2,5,1],3
 * 输出
 * [4,4,6,6,6,5]
 **/
public class MaxInWindows {

    /**
     * 优先级队列。时间复杂度 O(num.length * size)
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0 || size > num.length) {
            return list;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> (y - x));
        for (int i = 0; i < size; i++) {
            heap.offer(num[i]);
        }
        list.add(heap.peek());

        //每次循环移除窗口第一个元素，添加窗口后面下个元素
        for (int i = 0; i < num.length - size; i++) {
            heap.remove(num[i]);
            heap.offer(num[i + size]);
            list.add(heap.peek());
        }
        return list;
    }
}
