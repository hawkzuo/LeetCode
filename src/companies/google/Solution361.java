package companies.google;

/**
 * Bomb Enemy
 * Require scanning in 4 directions
 * Created by Amos on 2017/6/11.
 */
public class Solution361 {
    private int maxKill;

    public int maxKilledEnemies(char[][] grid) {

        if(grid == null ){  return 0;}
        int row = grid.length;
        if(row == 0){   return 0;}
        int col = grid[0].length;
        if(col == 0){   return 0;}
        maxKill = Integer.MIN_VALUE;

        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            updateRow(grid,i,true,dp);
            updateRow(grid,i,false,dp);
        }
        for(int j=0;j<col;j++){
            updateCol(grid,j,true,dp);
            updateCol(grid,j,false,dp);
        }

        if(maxKill > Integer.MIN_VALUE){    return maxKill; }
        else{   return 0;   }

    }
    private void updateRow(char[][] grid, int k, boolean isLeft, int[][] dp){
        if(isLeft){
            int counter = 0;
            for(int i=0;i<grid[k].length;i++){

                if(grid[k][i] == 'W'){
                    counter=0;
                }else if(grid[k][i] == 'E'){
                    counter++;
                }else{
                    dp[k][i] += counter;
                    maxKill = Math.max(maxKill,dp[k][i]);
                }
            }
        }else{
            int counter = 0;
            for(int i=grid[k].length-1;i>=0;i--){

                if(grid[k][i] == 'W'){
                    counter=0;
                }else if(grid[k][i] == 'E'){
                    counter++;
                }else{
                    dp[k][i] += counter;
                    maxKill = Math.max(maxKill,dp[k][i]);
                }
            }
        }
    }
    private void updateCol(char[][] grid, int k, boolean isUp, int[][] dp){
        if(isUp){
            int counter = 0;
            for(int i=0;i<grid.length;i++){

                if(grid[i][k] == 'W'){
                    counter=0;
                }else if(grid[i][k] == 'E'){
                    counter++;
                }else{
                    dp[i][k] += counter;
                    maxKill = Math.max(maxKill,dp[i][k]);
                }
            }
        }else{
            int counter = 0;
            for(int i=grid.length-1;i>=0;i--){

                if(grid[i][k] == 'W'){
                    counter=0;
                }else if(grid[i][k] == 'E'){
                    counter++;
                }else{
                    dp[i][k] += counter;
                    maxKill = Math.max(maxKill,dp[i][k]);
                }
            }
        }
    }
}
