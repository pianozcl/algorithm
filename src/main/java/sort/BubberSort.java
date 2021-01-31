package sort;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/1/31  2:05 PM
 * @description: 冒泡
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
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        int[] ints = new BubberSort().MySort(arr);
        System.out.println(JSON.toJSONString(ints));
    }
}
