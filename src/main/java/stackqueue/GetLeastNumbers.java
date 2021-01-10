package stackqueue;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  4:47 PM
 * @description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 **/
public class GetLeastNumbers {

    /**
     * 思路 ： 优先级队列的使用
     **/
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if (k == 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //这里创建大根堆，堆顶元素最大
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            //如果堆顶元素小于当前元素，弹出堆顶，当前元素从队尾入对，并通过浮动到合适对位置
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(6);
        integers.add(8);

        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        //比较器，如果 -1 和 0 代表不需要调整位置。1 代表需要调整位置
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });

        queue.offer(3);
        queue.offer(6);
        queue.offer(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }
}
