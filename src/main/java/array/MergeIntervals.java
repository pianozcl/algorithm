package array;

import com.alibaba.fastjson.JSON;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/6/7  4:34 PM
 * @description: 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * [[1,4],[2,3]]
 * [[1,3],[2,6],[8,10],[15,18]]
 * [[2,3],[4,5],[6,7],[8,9],[1,10]]
 * [[1,10],[2,3],[4,5],[6,7],[8,9]]
 *
 **/
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        //先根据第一列进行排序
        Arrays.sort(intervals, (x, y)-> x[0] - y[0]);
        int start = intervals[0][0], end = intervals[0][1];
        int[][] help = new int[intervals.length][];

        int p = 0;//用于记录help下标，以及res数组长度
        for (int i = 0; i < intervals.length - 1; i++) {
            //end小于下个数组第一个元素，说明出现区间，新数组添加当前坐标，并更新start和end
            if (end < intervals[i + 1][0]) {
                help[p++] = new int[]{start, end};
                start = intervals[i + 1][0];
                end = intervals[i + 1][1];

                //当前end假如在下一个数组之间，直接更新end。
            } else if (end >= intervals[i + 1][0] && end <= intervals[i + 1][1]) {
                end = intervals[i + 1][1];
            }
            //end大于下个数组第二个元素，不做任何处理
        }

        //循环为intervals.length - 1，最后需加上
        help[p++] = new int[]{start, end};
        int[][] res = new int[p][];

        //拷贝到新数组
        System.arraycopy(help, 0, res, 0, p);
        return res;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] arr2 = new int[][]{{1,4}, {4,5}};
        int[][] merge = merge(arr);
        int[][] arr3 = new int[][]{{19,22},{5,6},{2,10},{15,18}};
        int[][] arr4 = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(JSON.toJSONString(merge(arr4)));



    }
}
