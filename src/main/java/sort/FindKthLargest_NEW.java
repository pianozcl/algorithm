package sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author : chenliangzhou
 * create at:  2021/7/22  6:16 PM
 * @description:
 **/
public class FindKthLargest_NEW {
    public static void main(String[] args) {
        int[] arr = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        //Arrays.sort(arr);
        //System.out.println(JSON.toJSONString(arr));
        //[16920,48715,51047,123866,190970,218188,252932,259266,261485,328656,332380,349690,486232,520911,566715,673887,753214,798663,821713,852300,860175,871248,883142,937247,968891,986578,1010556,1034406,1111670,1165786,1176397,1177178,1199799,1249664,1285209,1332802,1455178,1514891,1528217,1540395,1546744,1615405,1648782,1844960,1845742,1884022,1896237,1904944,1959818]
        System.out.println(arr.length);
        int kth = findKth(arr, arr.length, 24 - 1);
        System.out.println(kth);
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        return select(a, 0, a.length - 1, K);
    }

    public static int select(int[] arr, int begin, int end, int k) {
        int pivot = partition(arr, begin, end);
        if (pivot == k) {
            return arr[k];
        }
        return k < pivot ? select(arr, begin, pivot - 1, k) : select(arr, pivot + 1, end, k);
    }

    public static int partition(int[] arr, int begin, int end) {
        int counter = begin, pivot = end;
        for (int i = begin; i < end; i++) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, counter++);
            }
        }
        swap(arr, pivot, counter);
        return counter;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
