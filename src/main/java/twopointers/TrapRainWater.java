package twopointers;

/**
 * @author : chenliangzhou
 * create at:  2021/5/14  7:27 PM
 * @description: 42. 接雨水 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 **/
public class TrapRainWater {
    public int trap(int[] height) {
        int start = 0, end = height.length - 1, i = start, j = end;
        int volume = 0;
        while (i < j) {

            //左边低则i++,右边低则j--。这样中间比较高的地方才不会漏掉
            if (height[i] < height[j]) {
                if (height[++i] < height[start]) {
                    //如果从左到有都是小于左边界（start），则累加体积
                    volume += height[start] - height[i];
                } else {
                    //如果当前坐标大于等于左边界，更新左边界为当前坐标
                    start = i;
                }
            } else {
                if (height[--j] < height[end]) {
                    volume += height[end] - height[j];
                } else {
                    end = j;
                }
            }
        }
        return volume;
    }
}
