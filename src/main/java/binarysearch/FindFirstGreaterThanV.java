package binarysearch;

/**
 * @author : chenliangzhou
 * create at:  2021/2/6  9:07 PM
 * @description: 二分查找，找到第一个比目标大的值坐标。
 *
 * 5,4,[1,2,4,4,5]      输出3
 **/
public class FindFirstGreaterThanV {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int l = 0;
        int r = n - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (a[mid] > v) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (a[mid] >= v) {
            while (mid >= 0 && a[mid] >= v) {
                mid--;
            }
            return mid + 2;
        } else {
            while (mid <= n - 1 && a[mid] <= v) {
                mid++;
            }
            return mid + 1;
        }
    }
}
