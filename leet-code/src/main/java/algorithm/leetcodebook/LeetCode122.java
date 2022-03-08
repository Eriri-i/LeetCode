package algorithm.leetcodebook;

import org.junit.Test;

/**
 * @description:
 * @author: tangshijie
 * @date: 2022/3/8
 */
public class LeetCode122 {
    /**
     * LeetCode 122 买卖股票的最佳时机
     * <p>
     * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
     * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润。
     * <p>
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        // dp数组 profit[i][0] 表示第i天不持有股票时的最大利润
        // profit[i][1] 表示第i天持有股票时的最大利润
        int[][] profit = new int[length][2];
        for (int i = 0; i < prices.length; i++) {
            // base case
            if (i == 0) {
                profit[0][0] = 0;
                profit[0][1] = -prices[0];
                continue;
            }
            // 当天不持有股票时的最大利润计算方式
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            // 当天持有股票时的最大利润计算方式
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
        }
        // 最后一天不持有股票时的利润为最大利润
        return profit[length - 1][0];
    }

    @Test
    public void test() {
        int[] price = {1,2,3,4,5};
        int maxProfit = maxProfit(price);
        assert maxProfit==4;
    }
}
