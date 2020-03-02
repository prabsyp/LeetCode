/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *            Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 */

public class BuySellStock {
	public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        if(len == 1) {
            return 0;
        }
        int[] greatest = new int[len];
        greatest[len-1] = prices[len -1];
        for(int i = prices.length -2; i>=0; i--) {
            if(prices[i] > greatest[i+1]) {
                greatest[i] = prices[i];
            }
            else {
                greatest[i] = greatest[i+1];
            }
        }
        
        int max = 0;
        for(int i = 0; i< len; i++) {
            int diff = greatest[i] - prices[i];
            if(diff > max) {
                max = diff;
            }
        }
        
        return max;
    }
}
