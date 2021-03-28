package sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2020/11/15  10:37 PM
 * @description: 快速排序，荷兰国旗快排
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
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

    /**
     * 定义一个划分方法，把一个数组小于num（基准数）的放左边，等于num的放中间，大于num的放右边
     * 小于区域推动等于区域向右，等于区域到大于区域待定，终止curr（l） = more
     * @param arr   原始数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @param num   基准数
     * @return
     */
    public static int[] partition(int arr[], int l, int r, int num) {
        // less代表小于区域左边界，more代表大于区域右边界
        int less = l - 1;
        int more = r + 1;

        // l相当于用来对数组遍历的下标，终止条件l<more;
        while (l < more) {
            if (arr[l] < num) {
                // less右移，这里要先右移再交换，因为less初始值为-1
                // l和less下标数进行交换
                int temp = arr[l];
                arr[l++] = arr[++less];
                arr[less] = temp;

            } else if (arr[l] > num) {

                // 大于区域的边界左移
                int temp = arr[l];
                arr[l] = arr[--more];
                arr[more] = temp;
                // l下标数值发生变化，需要再次判断新数值，因此l下标停一步

            } else {
                // 当l下标数值等于num，l右移继续遍历
                l++;
            }
        }

        // 返回等于num区域的左右边界下标
        return new int[] { less + 1, more - 1 };
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 以arr[r]作为基准数，获得划分下标
            int[] a = partition(arr, l, r, arr[r]);

            // 进而分别对左右两边进行递归排序
            quickSort(arr, l, a[0] - 1);
            quickSort(arr, a[1] + 1, r);
        }
    }

}
