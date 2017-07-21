package collectionMedium;

/**
 * Created by Amos on 2017/7/23.
 * Set Matrix Zeroes
 */
public class Sol073 {

    // To do this in place, use the upper and leftmost lines to store the flags for each row/col except themselves
    // For these two special lines, use extra flag rowFlag and colFlag to mark
    // Important coincidence: If inspected '0', then the row/col we use to mark will finally be '0', thus no need to
    // store the original values in the first row/column.     => Key for in-place

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){ return;}
        int col = matrix[0].length;
        int row0Flag=-1; int col0Flag=-1;

        if(matrix[0][0] == 0){
            row0Flag = 0;
            col0Flag = 0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0){	continue;}
                if(matrix[i][j] == 0){
                    if(i == 0){
                        row0Flag = 0;
                    }else if(j == 0){
                        col0Flag = 0;
                    }else{
                        // i,j>0
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        // Start with index=1 row
        for(int i=1;i<row;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<col;j++){
                    matrix[i][j]=0;
                }
            }
        }
        // Start with index=1 column
        for(int j=1;j<col;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<row;i++){
                    matrix[i][j]=0;
                }
            }
        }
        // Finally mark index=0 row & column separately
        if(row0Flag == 0){
            for(int j=1;j<col;j++){
                matrix[0][j]=0;
            }
        }
        if(col0Flag == 0){
            for(int i=1;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }

    public void setZeroesNotInplace(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){ return;}
        int col = matrix[0].length;

        int rows[] = new int[row];
        int cols[] = new int[col];


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i=0;i<row;i++){
            if(rows[i] == 1){
                for(int j=0;j<col;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=0;j<col;j++){
            if(cols[j] == 1){
                for(int i=0;i<row;i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
