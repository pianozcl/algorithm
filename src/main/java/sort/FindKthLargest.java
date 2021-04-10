package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/3/24  9:18 PM
 * @description: 找到第K大大数
 **/
public class FindKthLargest {


    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速选择（基于快排思想）
     * @param arr
     * @param begin
     * @param end
     * @param target
     * @return
     */
    public static int quickSelect(int[] arr, int begin, int end, int target) {
        int pivot = randomPartition(arr, begin, end);

        //当基准数下标等于target下标，第k大的数即为当前下标
        if (pivot == target) {
            return arr[target];
        }
        //根据pivot大小，每次只对其中一边递归。时间复杂度O（n）
        return pivot < target ? quickSelect(arr, pivot + 1, end, target) : quickSelect(arr, begin, pivot - 1, target);
    }

    /**
     * 划分方法
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int partition(int[] arr, int begin, int end) {
        //counter记录小于基准数的边界下标
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, counter++, i);
            }
        }
        swap(arr, counter, pivot);
        return counter;
    }

    /**
     * 随机划分方法
     */
    static Random random = new Random();
    public static int randomPartition(int[] arr, int begin, int end) {
        int i = random.nextInt(end - begin + 1) + begin;

        //选数组中的随机一个数，与end下标元素交换, 随机快排思想，防止形如[1,2,3,4,5,6...]的数组，每次进行partition都会分到左边，时间复杂度退化到O(n^2)
        swap(arr, i, end);
        return partition(arr, begin, end);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] arr1 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            int rand = random.nextInt(100000);
            arr1[i] = rand;
        }

        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        //验证：arr1深拷贝arr2（两个数组元素相同，不同内存空间）
        //arr1第300大，应改等于排序后arr2 1000 - 300 = 700下标元素
        int i = findKthLargest(arr1, 300);
        System.out.println(i);

        Arrays.sort(arr2);
        System.out.println(arr2[700]);
    }
}
