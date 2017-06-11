//123. Best Time to Buy and Sell Stock III

package dynamicprogramming;

public class Solution123 {

    public int maxProfit(int[] prices) {
        int k=2;
    	int len = prices.length;
        if (k >= len / 2) return greedySolve(prices);
        
        int[][] dp = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
        	int localMax = dp[i-1][0] - prices[0];
        	for (int j = 1; j < len; j++) {
        		//Update maxprofit-startcost of previous (j-1) items in (k-1) transactions
        		localMax = Math.max(localMax,dp[i-1][j-1] - prices[j-1]);
        		
        		dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
        	}
        }
        return dp[k][len-1];
    }
    private int greedySolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
