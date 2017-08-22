package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/8/22.
 * Maximal Square
 */
public class Sol221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0) {  return 0;}
        int globalMax = 0;
        // Initialize
        int row = matrix.length;    int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++) {
            if(matrix[i][col-1] == '0') {
                dp[i][col-1] = 0;
            }else if (matrix[i][col-1] == '1') {
                dp[i][col-1] = 1;
                globalMax = 1;
            }
        }
        for(int j=0;j<col;j++) {
            if(matrix[row-1][j] == '0') {
                dp[row-1][j] = 0;
            }else if (matrix[row-1][j] == '1') {
                dp[row-1][j] = 1;
                globalMax = 1;
            }
        }
        // Sub-problem is the dimension of square with left-upper point being A[i][j]
        // Since the update is updated row by row / col by col, space cost can be optimized to O(n/m)
        // But it's meaningless, because the input is already O(mn) space cost.
        for(int j=col-2;j>=0;j--) {
            for(int i=row-2;i>=0;i--) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1+Math.min(Math.min(dp[i+1][j] , dp[i][j+1]), dp[i+1][j+1]);
                    globalMax = Math.max(globalMax, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return globalMax * globalMax;
    }
}
