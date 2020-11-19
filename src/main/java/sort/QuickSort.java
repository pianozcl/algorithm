package sort;

/**
 * @author : chenliangzhou
 * create at:  2020/11/15  10:37 PM
 * @description: 快速排序
 **/
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = { 4,2,1,7,5,3,6,5 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 定义一个划分方法，把一个数组小于num（基准数）的放左边，等于num的放中间，大于num的放右边
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
                less++;

                // l和less下标数进行交换
                int temp = arr[l];
                arr[l] = arr[less];
                arr[less] = temp;

                // l下边右移
                l++;
            } else if (arr[l] > num) {

                // 大于区域的边界左移
                more--;
                int temp = arr[l];
                arr[l] = arr[more];

                // l下标数值发生变化，需要再次判断新数值，因此l下标停一步
                arr[more] = temp;
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
