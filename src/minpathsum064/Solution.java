package minpathsum064;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

    public int minPathSum(int[][] grid) {
   	
    	int row=grid.length;  int col=grid[0].length;
    	int [][]dp = new int[row][col];
//Initialize first columns and rows of dp
    		for(int i=0;i<col;i++){
    			if(i==0){
    				dp[0][i]=grid[0][i];
    			}else{
    				dp[0][i]=dp[0][i-1]+grid[0][i];
    			}
    		}
    		for(int j=0;j<row;j++){
    			if(j==0){
    				dp[j][0]=grid[j][0];
    			}else{
    				dp[j][0]=dp[j-1][0]+grid[j][0];
    			}
    		}
    		
        if(row==1){
        		return dp[0][col-1];
        	}
        if(col==1){
        	return dp[row-1][0];	
    	}
    	
    	boolean row_greater=false;
    	int commonstep=0;
    	if(row > col){
    		row_greater=true;
    		commonstep=col-2;
    	}else{
    		row_greater=false;
    		commonstep=row-2;
    	}  	   
    	//Shared path Note that this is <=
    	for(int i=1;i<=commonstep;i++){
    		//Column
    		for(int j=i;j<row;j++){
    			dp[j][i]=Math.min(dp[j][i-1], dp[j-1][i])+grid[j][i];
    		}
    		//Row
    		for(int k=i;k<col;k++){
    			dp[i][k]=Math.min(dp[i][k-1], dp[i-1][k])+grid[i][k];
    		}    		
    	}
    	
    	if(row_greater){
    		//An extra Column needed
    		for(int j=col-1;j<row;j++){
    			dp[j][col-1]=Math.min(dp[j][col-2], dp[j-1][col-1])+grid[j][col-1];
    		}
    	}else{
    		//An extra Row needed
    		for(int k=row-1;k<col;k++){
    			dp[row-1][k]=Math.min(dp[row-2][k], dp[row-1][k-1])+grid[row-1][k];
    		}
    	}
    	
    	return dp[row-1][col-1];    	
    }	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int [][] ref={{1,5,9},{2,6,10},{3,7,11},{4,8,12}};

		System.out.println(s.minPathSum(ref));
	}

}
