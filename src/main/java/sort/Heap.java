package sort;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * @author : chenliangzhou
 * create at:  2021/3/16  9:06 PM
 * @description: 堆
 **/
public class Heap {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,7,4,3};
        //int[] arr2 = new int[]{5,2,3,1};
        heapSort(arr);

        //vertify();
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;

        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    public static void heapSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //System.out.println(JSON.toJSONString(arr));//[7,5,3,1,4,2]
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);      //每次heapify，下沉的过程中，把最大值置换到堆顶
            swap(arr, 0, --heapSize);           //交换，把最大值放到末尾
        }
    }

    /**
     * 大根堆
     * 插入过程进行上浮
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {

        //如果当前节点小于父节点，跟父节点交换，直到父节点大于当前节点
        while (arr[index] > arr[(index - 1) / 2]) {
            //交换
            swap(arr, index, (index - 1) / 2);

            //当前节点下标等于父节点下标
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆中某个节点变小下沉过程
     * @param arr
     * @param index
     * @param heapSize 堆边界
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        //当前index节点左节点下标, left + 1即为右节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            //获取左右节点最大节点下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            //当前节点跟左右节点中最大的比较（获取最大值下标）
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对数器
     * @param
     * @param
     * @return
     */
    public static void vertify() {
        for (int i = 0; i < 10000; i++) {
            int[][] arrs = randomArray();
            heapSort(arrs[0]);
            heapSort2(arrs[1]);
            if (JSON.toJSONString(arrs[0]).equals(JSON.toJSONString(arrs[1]))) {
                System.out.println("true");
            } else {
                System.out.println(JSON.toJSONString(arrs[0]));
                System.out.println(JSON.toJSONString(arrs[1]));
            }
        }
    }

    public static int[][] randomArray() {
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50000);
        }
        return new int[][]{arr, arr};
    }

}
