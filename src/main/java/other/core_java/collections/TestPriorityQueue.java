package other.core_java.collections;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/4/17  9:53 PM
 * @description:
 **/
public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(100, (x, y) -> (y - x));

        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int val = random.nextInt(Integer.MAX_VALUE);
            if (queue.size() < 100) {
                queue.offer(val);
            } else {
                if (queue.peek() > val) {
                    queue.poll();
                    queue.offer(val);
                }
            }
            arr[i] = val;
        }
        Arrays.sort(arr);

        System.out.println(JSON.toJSONString(queue));   //优先级队列，大根堆，取最小的100个元素
        System.out.println(JSON.toJSONString(arr));     //所有排序好堆元素
        System.out.println(arr[99]);        //在queue里
        System.out.println(arr[100]);       //不在queue里
    }
}
