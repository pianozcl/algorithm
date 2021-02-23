package dp;

/**
 * @author : chenliangzhou
 * create at:  2021/2/22  9:22 AM
 * @description: 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 **/
public class MaxProfitOnce {
    public int maxProfit (int[] prices) {
        // write code here
        int cost = 0x7fffffff;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }
}
