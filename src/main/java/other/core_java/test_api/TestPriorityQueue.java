package other.core_java.test_api;

import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/7/18  8:49 PM
 * @description: 优先级队列
 **/
public class TestPriorityQueue {
    public static void main(String[] args) {
        //默认a - b小顶堆。b - a大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
    }
}
