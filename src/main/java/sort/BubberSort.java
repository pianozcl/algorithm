package sort;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/1/31  2:05 PM
 * @description: 冒泡
 * 平均时间复杂度O(n^2)
 **/
public class BubberSort {
    public int[] MySort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("循环1");
            }
        }
        return arr;
    }

    /**
     * 优化版，最好时间复杂度O(n)
     * 稳定排序，如果元素相等，则不进行排序
     * @param arr
     */
    public void bubberSort(int[] arr) {
        boolean didSwap = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
                System.out.println("循环2");
            }
            //如果为false，说明没有交换，也就是数组有序。直接返回。此时只经过一趟遍历，时间复杂度O（n）
            if (didSwap == false) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        int[] ints = new BubberSort().MySort(arr);
        System.out.println(JSON.toJSONString(ints));

        int[] arr2 = {1,2,3,4,5};
        new BubberSort().bubberSort(arr2);
        System.out.println(JSON.toJSONString(arr2));

        int[] arr3 = new int[] {1,5,2,3,6};
        new BubberSort().bubberSort(arr3);
        System.out.println(JSON.toJSONString(arr3));
    }
}
