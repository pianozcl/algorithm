package array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author : chenliangzhou
 * create at:  2021/7/12  11:47 PM
 * @description: NC41 最长无重复子数组
 **/
public class MaxLength {
    public static void main(String[] args) {

    }

    public static int maxLength (int[] arr) {

        // write code here
        int max = 0;
        LinkedList list = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            while (list.contains(arr[i])) {
                list.removeFirst();
            }
            list.add(arr[i]);
            max = Math.max(max, list.size());
        }
        return max;
    }
}
