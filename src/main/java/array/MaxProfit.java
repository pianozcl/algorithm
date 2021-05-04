package array;

/**
 * @author : chenliangzhou
 * create at:  2020/10/9  2:49 PM
 * @description: 股票最大收益：假定你知道某只股票每一天价格的变动。 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。 请设计一个函数，计算你所能获得的最大收益。
 * 示例1
 * 输入[5,4,3,2,1]
 * 输出0
 * 示例2
 * 输入[1,2,3,4,5]
 * 输出4
 **/
public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 57, 30, 82, 90, 12, 5, 13};
        System.out.println(maxProfit(arr));
    }

    /**
     * 时间复杂度O(n)解法
     * 思路：把大数组拆分成升序子数组求和
     * 例如：2，4，10，57，30，82，90，12，5，13
     * 可拆分为[2，4，10，57]   [30，82，90]   [12]    [5，13]
     * 结果为(57-2)+(90-30)+(12-12)+(13-5)=123
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                max = max + (prices[i - 1] - prices[start]);
                start = i;
            }
        }
        //由于是根据元素是否变小，来判断是否为子数组最后元素的坐标。因此在循环中最后的升序数组未被累加，返回时单独加上
        return max + prices[prices.length - 1] - prices[start];
    }
}
