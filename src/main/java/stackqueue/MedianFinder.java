package stackqueue;

import java.util.PriorityQueue;

/**
 * @author : chenliangzhou
 * create at:  2021/1/9  9:12 PM
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 **/
public class MedianFinder {
    private int count;
    private PriorityQueue<Integer> maxHeap; //大根堆
    private PriorityQueue<Integer> minHeap; //小根堆

    public MedianFinder() {
        this.count = 0;
        this.maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        this.minHeap = new PriorityQueue<>();
    }

    public void Insert(Integer num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        //如果总数为奇数个，小根堆堆顶给大根堆（奇数个保持大根堆比小根堆多一个数，偶数两者均分）
        if ((count & 1) != 0) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 0) {
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        } else {
            return new Double(maxHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int[] arr = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i : arr) {
            medianFinder.Insert(i);
        }

        System.out.println(medianFinder.GetMedian());
    }
}
