package uniquepaths062;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	
	}
    public int uniquePaths(int m, int n) {
    	if(m==1 || n==1){	return 1;}
/* Reverse Version
    	int max=Math.max(m, n); int min=Math.min(m, n);
    	int [][]dp = new int[min+1][max+1];
    	for(int i=0;i<=min;i++){
    		dp[i][1]=1;
    	}
    	for(int j=0;j<=max;j++){
    		dp[1][j]=1;
    	}

    	return DFS(dp,max,min);
*/
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
/*
    private int DFS(int[][] dp,int max,int min){
    	for(int i=2;i<=min;i++){
    		for(int j=i;j<=max;j++){
    			if(i==j){
    				dp[i][j]=2*dp[i-1][j];
    			}else{
    				dp[i][j]=dp[i][j-1]+dp[i-1][j];
    			}    			    			
    		}    		    		
    	}
    	return dp[min][max];
    }
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.println(s.uniquePaths(40, 10));
		
		
	}

}
