//265. Paint House II

package tags.dynamicprogramming;

public class Solution265 {

    public int minCostII(int[][] costs) {
        
        int n=costs.length;
        if(n==0){   return 0;}
        
        int k=costs[0].length;
        if(k==0){   return 0;}
        
        int[][] dp = new int[n+1][k+1];
        
        for(int z=1;z<=k;z++){
            
            dp[1][z] = costs[0][z-1];
            
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=k;j++){
                
                int mincost=Integer.MAX_VALUE;
                for(int z=1;z<=k;z++){
                    if(z==j){   continue;}
                    mincost = Math.min(mincost, dp[i-1][z]+costs[i-1][j-1]);
                    
                }
                dp[i][j]=mincost;
                
            }
            
        }
        
        int mincst=Integer.MAX_VALUE;
        for(int z=1;z<=k;z++){
            mincst = Math.min(mincst,dp[n][z]);
            
        }
        return mincst;
  
    }
	public static void main(String[] args) {
		
		Solution265 s = new Solution265();
		int[][] tes = {{8,7,2,3},{4,5,1,3},{2,4,7,9},{1,3,4,2}};
		System.out.println(s.minCostII(tes));
		
	}

}
