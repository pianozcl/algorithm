package other;

import basestructure.ListNode;
import basestructure.TreeNode;
import binarytree.LevelOrder;
import com.alibaba.fastjson.JSON;
import sun.jvm.hotspot.debugger.Page;
import util.test.TestStructure;

import java.util.*;

/**
 * @author : chenliangzhou
 * create at:  2021/3/19  1:42 PM
 * @description:
 **/
public class OtherTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,3,7,2,3,7};
        sort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void sort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(arr, begin, end);
        sort(arr, begin, pivot - 1);
        sort(arr, pivot + 1, end);
    }


    public static int partition(int[] arr, int begin, int end) {
        int counter = begin, pivot = end;
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
        arr[j] =temp;
    }

}
