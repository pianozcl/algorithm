package sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/3/24  8:47 PM
 * @description: 经典快排，基准数（prvot）只有一个元素
 **/
public class QuickSortClassic {

    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        //counter记录小于基准数到边界下标
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, counter++, i);
            }
        }
        swap(arr, counter, pivot);
        return counter;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //对数器
        int[] arr1 = new int[10000];
        int[] arr2 = new int[10000];

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(100000);
            arr1[i] = r;
            arr2[i] = r;
        }

        quickSort(arr1, 0, arr1.length - 1);
        Arrays.sort(arr2);

        System.out.println(JSON.toJSONString(arr1));
        System.out.println();
        System.out.println(JSON.toJSONString(arr2));

        System.out.println(JSON.toJSONString(arr1).equals(JSON.toJSONString(arr2)));
    }

}
