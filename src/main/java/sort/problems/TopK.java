package sort.problems;

import com.alibaba.fastjson.JSON;
import sort.FindKthLargest;
import sort.Heap;
import sort.MergeSort;
import sort.QuickSort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/4/17  8:12 PM
 * @description:
 **/
public class TopK {
    public static void main(String[] args) {
        Random random = new Random();

        //4G的堆内存空间  这里把堆大小设置为8G用于测试，-Xms8000m -Xmx8000m
        //int[] arr = new int[1000000000];

        //for (int i = 0; i < arr.length; i++) {
        //    arr[i] = random.nextInt(Integer.MAX_VALUE);
        //}

        int[] res = new int[1000];

        long t1 = System.currentTimeMillis();
        //Arrays.sort(arr); //90s
        //QuickSort.quickSort(arr, 0, arr.length - 1); //153s
        System.out.println("开始排序");
        //Heap.heapSort(arr);             // 超慢

//        for (int i = 0; i < res.length; i++) {
//            int kthLargest = FindKthLargest.findKthLargest(arr, i + 1);   //超慢
//            res[i] = kthLargest;
//        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(1000000000);
        for (int i = 0; i < 1000000000; i++) {
            queue.offer(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }

        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / 1000);

//        for (int i = 0; i < res.length; i++) {
//            res[i] = arr[i];
//        }


        System.out.println(JSON.toJSONString(res));
    }
}
