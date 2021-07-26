package array;

import java.util.HashSet;

/**
 * @author : chenliangzhou
 * create at:  2021/7/19  12:24 AM
 * @description: NC75 数组中只出现一次的两个数字
 *
 * 描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 示例1
 * 输入：
 * [1,4,1,6]
 * 复制
 * 返回值：
 * [4,6]
 * 复制
 * 说明：
 * 返回的结果中较小的数排在前面
 **/
public class FindNumsAppearOnce {
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        Integer[] arr = set.toArray(new Integer[2]);
        int min = arr[0] < arr[1] ? arr[0] : arr[1];
        int max = arr[0] > arr[1] ? arr[0] : arr[1];
        return new int[]{min, max};
    }
}
