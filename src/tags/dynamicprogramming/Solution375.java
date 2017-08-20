//

package tags.dynamicprogramming;

public class Solution375 {

    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int [][] dp = new int[n+1][n+1];
        return getCost(1,n,dp);
    }
    

    
    private int getCost(int begin, int end, int[][] dp){
        if(begin >= end){
            return 0;
        }
        if(dp[begin][end] > 0){
            return dp[begin][end];
        }
       
        int resmin = Integer.MAX_VALUE;
        //Mind the loop corner
        for(int i=begin;i<=end;i++){
            
            int cost = i+Math.max(getCost(begin,i-1,dp),getCost(i+1,end,dp));
            resmin = Math.min(cost,resmin);
            
        }
        
        dp[begin][end] = resmin;
        return resmin;
      
    }

}
