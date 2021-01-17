package greedy;

/**
 * @author : chenliangzhou
 * create at:  2021/1/14  6:31 PM
 * @description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int cost = 0x7fffffff;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }
}
