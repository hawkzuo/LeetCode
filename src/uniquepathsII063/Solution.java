package uniquepathsII063;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    	int row=obstacleGrid.length;
    	int col=obstacleGrid[0].length;
    	
    	int [][]dp=new int[row][col];
    	boolean stuck=false;
    	
    	for(int i=0;i<row;i++){
    		if(stuck){

    			dp[i][0]=0;
    		}else if(obstacleGrid[row-1-i][col-1] == 1){
    			//has a stuck ;mind above to have 0 or not
    			stuck=true;
    			if(col == 1 || i==0){
    				return 0;
    			}
    			dp[i][0]=0;
    		}else{
    			dp[i][0]=1;
    		}   		    		
    	}
    	stuck=false;
    	for(int j=0;j<col;j++){
    		if(stuck){

    			dp[0][j]=0;
    		}else if(obstacleGrid[row-1][col-1-j] == 1){
    			//has a stuck
    			stuck=true;
    			if(row == 1 || j==0){
    				return 0;
    			}
    			dp[0][j]=0;
    		}else{
    			dp[0][j]=1;
    		} 
    	}    	
    	return DFS(dp,obstacleGrid,row,col);
    }	
    private int DFS(int[][] dp,int [][]refer,int row,int col){
    	if(row==1 || col==1 ){return 1;}
    	
    	boolean row_greater=false;
    	int commonstep=0;
    	if(row > col){
    		row_greater=true;
    		commonstep=col-2;
    	}else{
    		row_greater=false;
    		commonstep=row-2;
    	}  	    	
    	
    	for(int i=1;i<=commonstep;i++){
    		for(int j=i;j<col;j++){
    			if(refer[row-1-i][col-1-j] == 1){
    				dp[i][j]=0;
    			}else{
    				dp[i][j]=dp[i][j-1]+dp[i-1][j];
    			}
    		}
    		for(int j=i;j<row;j++){
    			if(refer[row-1-j][col-1-i] == 1){
    				dp[j][i]=0;
    			}else{
    				dp[j][i]=dp[j][i-1]+dp[j-1][i];
    			}
    		}    		   		    		
    	}
    	
    	//At first, I didn't compare the two different situations.
    	
    	
    	
    	if(row_greater){
    		for(int i=col-1;i<row;i++){
    			if(refer[row-1-i][0] == 1){
    				dp[i][col-1]=0;
    			}else{
    				dp[i][col-1]=dp[i][col-2]+dp[i-1][col-1];
    			}
    		}    		
    	}else{
    		for(int i=row-1;i<col;i++){
    			if(refer[0][col-1-i] == 1){
    				dp[row-1][i]=0;
    			}else{
    				dp[row-1][i]=dp[row-1][i-1]+dp[row-2][i];
    			}
    		}
    		   		
    	}
    	
    	return dp[row-1][col-1];
    }	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int[][] obs ={{0,0,0,0,0,0,1},{0,0,1,0,0,0,0},{0,0,0,1,0,0,0}};
		int[][] obs2={{0,0},{1,1},{0,0}};
		System.out.println(s.uniquePathsWithObstacles(obs2));
		
		
	}

}
