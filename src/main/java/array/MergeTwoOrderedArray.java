package array;

/**
 * @author : chenliangzhou
 * create at:  2020/9/30  12:57 PM
 * @description: 合并两个有序数组
 **/
public class MergeTwoOrderedArray {
    public static void main(String[] args) {
        int[] arra={1,2,3,4,0,0,0,0,0};
        int[] arrb={3,4,5,7};
        merge(arra,4,arrb,4);

        for (int i : arra) {
            System.out.println(i);
        }


    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[m + n];
        int i = 0, j = 0, p = 0;
        while (i < m && j < n) {
            help[p++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            help[p++] = nums1[i++];
        }
        while (j < n) {
            help[p++] = nums2[j++];
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = help[k];
        }
    }
}
