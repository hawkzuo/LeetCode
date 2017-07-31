package collectionMedium;

/**
 * Created by Amos on 2017/7/27.
 * Unique Binary Search Trees
 */
public class Sol096 {
    public int numTrees(int n) {
        if(n<=0){   return 0;}
        int[] dp = new int[n+1];
        dp[0]=1;    dp[1]=1;
        return getNum(n,dp);
    }
    private int getNum(int i,int[] dp){
        if(dp[i]!=0){
            return dp[i];
        }
        int sum=0;
        for(int k=0;k<i;k++){
            sum+=getNum(k,dp)*getNum(i-k-1,dp);
        }
        dp[i]=sum;
        return dp[i];
    }
}
