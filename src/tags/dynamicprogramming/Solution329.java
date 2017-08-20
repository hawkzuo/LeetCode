//329. Longest Increasing Path in a Matrix

package tags.dynamicprogramming;

public class Solution329 {

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if(m == 0){ return 0;}
        
        int n = matrix[0].length;   
        if(n == 0){ return 0;}
        
        int max = 0;
        int [][] dp = new int[m][n];
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                max = Math.max(max,dfsVisit(i,j,matrix,dp));
            }
            
        }
        
        return max;
        
        
        
        
    }
    
    
    
    private int dfsVisit(int i, int j,  int[][] matrix, int[][] dp){
        
        if(getMatrix(dp,i,j)>0){
            return dp[i][j];
        }
        
        int c1,c2,c3,c4;
        
        int val = getMatrix(matrix,i,j);
        
        c1 = getMatrix(matrix,i-1,j);
        c2 = getMatrix(matrix,i+1,j);
        c3 = getMatrix(matrix,i,j-1);
        c4 = getMatrix(matrix,i,j+1);
        
        //Begin DFS
        if(c1 > val){
            
            c1 = dfsVisit(i-1,j,matrix,dp);
        }else{
            c1 = 0;
        }
        if(c2 > val){
            
            c2 = dfsVisit(i+1,j,matrix,dp);
        }else{
            c2 = 0;
        }        
        if(c3 > val){
            
            c3 = dfsVisit(i,j-1,matrix,dp);
        }else{
            c3 = 0;
        }        
        if(c4 > val){
            
            c4 = dfsVisit(i,j+1,matrix,dp);
        }else{
            c4 = 0;
        }        
        
        //Finish visiting
        int cur = 1+Math.max(Math.max(Math.max(c1,c2),c3),c4);
        dp[i][j] = cur;

        return dp[i][j];
        
        
    }
    
    private int getMatrix(int[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;        
        
        if(i<0 || i>=m){
            return -1;
        }
        if(j<0 || j>=n){
            return -1;
        }
        return matrix[i][j];
    }

}
