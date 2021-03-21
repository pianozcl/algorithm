package sort;

import com.alibaba.fastjson.JSON;

/**
 * @author : chenliangzhou
 * create at:  2021/3/14  11:47 PM
 * @description: 交换-异或运算
 **/
public class SwapXor {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3};
        swap(arr, 0, 1);
        System.out.println(JSON.toJSONString(arr)); // 3, 2
    }

    /**
     * 计算过程，三次异或运算
     * 0010
     * 0011
     * 0001         arr[i] = 1
     *
     * 0001
     * 0011
     * 0010         arr[j] = 2
     *
     * 0001
     * 0010
     * 0011         arr[i] = 3
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
