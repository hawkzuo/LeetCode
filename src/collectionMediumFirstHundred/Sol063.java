package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/23.
 * Unique Paths II
 */
public class Sol063 {
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

        boolean row_greater;
        int commonStep;
        if(row > col){
            row_greater=true;
            commonStep=col-2;
        }else{
            row_greater=false;
            commonStep=row-2;
        }

        for(int i=1;i<=commonStep;i++){
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
}
