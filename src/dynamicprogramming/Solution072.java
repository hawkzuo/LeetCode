//72. Edit Distance

package dynamicprogramming;

public class Solution072 {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        if(m==0 || n==0){
            return Math.abs(m-n);
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m-i;
        }
        for (int i = 0; i <= n; i++) {
            dp[m][i] = n-i;
        }        
        return d_p(0,0,m,n,dp,c1,c2);
    }
    
    private int d_p(int i,int j,int m, int n, int[][] dp, char[] c1, char[] c2){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i == m && j==n){
            return 0;
        }
        if(c1[i] == c2[j]){
            dp[i][j] = d_p(i+1,j+1,m,n,dp,c1,c2);
        }else{
            dp[i][j] = 1+Math.min(Math.min(d_p(i+1,j+1,m,n,dp,c1,c2),d_p(i,j+1,m,n,dp,c1,c2)),d_p(i+1,j,m,n,dp,c1,c2));            
        }
        return dp[i][j];
    }

}
