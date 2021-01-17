package binarysearch;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  10:11 PM
 * @description: 统计一个数字在升序数组中出现的次数。
 * [1,2,3,3,3,3,4,5],3
 * 4
 **/
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int l = 0, r = array.length - 1, count = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] > k) {
                r = m - 1;
            } else if (array[m] < k) {
                l = m + 1;
            } else {
                int p = m;
                while (p <= array.length - 1 && array[p] == k) {
                    count++;
                    p++;
                }
                p = m - 1;
                while (p >= 0 && array[p] == k) {
                    count++;
                    p--;
                }
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3};
        int i = new GetNumberOfK().GetNumberOfK(arr, 3);
        System.out.println(i);
    }
}
