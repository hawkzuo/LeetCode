//188. Best Time to Buy and Sell Stock IV

package tags.dynamicprogramming;

public class Solution188 {

	
	//dp[k][n] only 2 choices : either including A[n] or not
	//	---Not including : dp[k][n-1]
	//  ----Including : need to find the Max value of previous candidate tmp
	//					---- tmp is designed to be on one hand max of making (k-1) transactions in (n-1) values
	//					---- on the other hand the value of A[n-1] matters two
	//					----- Thus tmp = Max(tmp,dp[n-1][k-1] - A[n-1])
	
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
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
    

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

}
