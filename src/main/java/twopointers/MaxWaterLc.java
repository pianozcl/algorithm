package twopointers;

/**
 * @author : chenliangzhou
 * create at:  2021/3/11  3:49 PM
 * @description: 输入：[1,8,6,2,5,4,8,3,7] 输出：49  解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 **/
public class MaxWaterLc {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * (height[l] < height[r] ? height[l++] : height[r--]));
        }
        return max;
    }
}
