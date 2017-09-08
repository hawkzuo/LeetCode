package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/6.
 * Paint House
 */
public class Sol256 {
    // Idea: DP[i][j] stores minCost till i's index element with color j
    // V1: bottom-up    V2: optimized bottom-up     V3: memoization
    // 0-R  1-B 2-G
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) {    return 0; }
        int n = costs.length;
        int[][] dp = new int[n][3];

        // Base case
        dp[0][1] = costs[0][1]; dp[0][0] = costs[0][0]; dp[0][2] = costs[0][2];

        // Main DP process
        for(int i=1; i<n; i++) {
            for(int j=0; j<=2; j++) {
                // A[i+1][j] = Min(A[i][k]) + cost(i+1, j) (k!=j)
                dp[i][j] = costs[i][j] + getCost(i, j, dp);
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

    private int getCost(int i, int j, int[][] dp) {
        int res = Integer.MAX_VALUE;
        for(int k=0; k<=2; k++) {
            if(k == j) {    continue; }
            res = Math.min(res, dp[i-1][k]);
        }
        return res;
    }

    // Optimized space cost version:
    public int minCostOptimized(int[][] costs) {
        if(costs == null || costs.length == 0) {    return 0; }
        int n = costs.length;
        int[] dp = new int[3];

        // Base
        dp[0] = costs[0][0];    dp[1] = costs[0][1];    dp[2] = costs[0][2];

        for(int i=1; i<n; i++) {
            int[] next = new int[3];
            for(int j=0; j<=2; j++) {
                // A[i+1][j] = Min(A[i][k]) + cost(i+1, j) (k!=j)
                next[j] = costs[i][j] + getCost1D(j, dp);
            }
            dp[0] = next[0];    dp[1] = next[1];    dp[2] = next[2];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    private int getCost1D(int j, int[] dp) {
        int res = Integer.MAX_VALUE;
        for(int k=0; k<=2; k++) {
            if(k == j) {    continue; }
            res = Math.min(res, dp[k]);
        }
        return res;
    }

    // Top-down fashion:
    public int minCostMemorized(int[][] costs) {
        if(costs == null || costs.length == 0) {    return 0; }
        int n = costs.length;
        int[][] dp = new int[n][3];

        // Base case
        dp[n-1][1] = costs[n-1][1]; dp[n-1][0] = costs[n-1][0]; dp[n-1][2] = costs[n-1][2];

        // Main DP process
        return Math.min(topDownSearching(0, 0, dp, costs),
                        Math.min(topDownSearching(0, 1, dp, costs),
                        topDownSearching(0, 2, dp, costs)));
    }

    private int topDownSearching(int i, int color, int[][] dp, int[][] costs) {
        if(dp[i][color] != 0) { return dp[i][color];}

        int nextLevelCost = Integer.MAX_VALUE;
        for(int k=0;k<=2;k++) {
            if(k == color) {    continue; }
            nextLevelCost = Math.min(nextLevelCost, topDownSearching(i+1, k, dp, costs));
        }
        dp[i][color] = nextLevelCost + costs[i][color];
        return dp[i][color];
    }
}
