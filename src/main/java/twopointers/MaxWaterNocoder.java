package twopointers;

/**
 * @author : chenliangzhou
 * create at:  2021/1/31  2:08 AM
 * @description: 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。 具体请参考样例解释
 **/
public class MaxWaterNocoder {

    public long maxWater (int[] arr) {
        int l = 0, r = arr.length - 1, i = l, j = r;
        long v = 0;
        while (i < j) {
            if (arr[l] < arr[r]) {
                if (arr[++i] < arr[l]) {
                    v += arr[l] - arr[i];
                } else {
                    l = i;
                }
            } else {
                if (arr[--j] < arr[r]) {
                    v += arr[r] - arr[j];
                } else {
                    r = j;
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        MaxWaterNocoder maxWaterNocoder = new MaxWaterNocoder();
        long l = maxWaterNocoder.maxWater(new int[]{3, 1, 2, 5, 2, 4});
        System.out.println(l);
    }
}
