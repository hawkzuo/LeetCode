package collectionMedium;

/**
 * Created by Amos on 2017/7/23.
 * Unique Paths
 */
public class Sol062 {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){	return 1;}
        int max=Math.max(m, n); int min=Math.min(m, n);
        int [][]dp = new int[max][min];
        for(int i=0;i<max;i++){
            dp[i][0]=1;
        }
        return DFS2(dp,max,min);
    }

    private int DFS2(int[][] dp, int max, int min){
        for (int i=1;i<min;i++){
            for(int j=i;j<max;j++){
                if(i==j){
                    dp[j][i]=2*dp[j][i-1];
                }else{
                    dp[j][i]=dp[j][i-1]+dp[j-1][i];
                }
            }
        }
        return dp[max-1][min-1];
    }
}
