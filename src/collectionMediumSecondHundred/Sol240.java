package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/10/18.
 * Search a 2D Matrix II
 */
public class Sol240 {
    // Idea: Greedy choice, starts from topRight position, till downLeft position
    public boolean searchMatrix(int[][] matrix, int target) {
        // Annoying Base Cases
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0;    int j=n-1;
        while(i < m && j >= 0) {
            int step = matrix[i][j];
            if(step == target) {
                return true;
            } else if (step < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
