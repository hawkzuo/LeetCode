package collectionHardFirstFifty;

/**
 * Created by Amos on 2017/8/29.
 * N-Queens II
 */
public class Sol052 {
    // Idea: Remove storing part will do
    private int counter = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        formQueen(board, 0, n);
        return counter;
    }
    private void updateForQueen(int[][] board, int x, int y, boolean isAdding) {
        int n = board.length;
        // Cols
        int offset = 1;
        if(!isAdding) { offset = -1;}
        for(int i=x+1; i<n;i++) {
            board[i][y] += offset;
        }
        // Downside diagonals
        int cx = x; int cy = y;
        while(cx+1 < n && cy+1 < n) {
            cx++;   cy++;
            board[cx][cy] += offset;
        }
        cx = x; cy = y;
        while(cx+1 < n && cy-1 >= 0) {
            cx++;   cy--;
            board[cx][cy] += offset;
        }
    }

    private void formQueen(int[][] board, int rowNumber, int dim) {
        // Base case
        if(rowNumber == dim-1) {
            for(int j=0;j<dim; j++) {
                if(board[rowNumber][j] == 0) {
                    // store
                    counter++;
                }
            }
        } else {
            // Row by row put queen
            for(int j=0; j<dim; j++) {
                if(board[rowNumber][j] == 0) {
                    // Update values below this row
                    board[rowNumber][j] = -1;
                    updateForQueen(board, rowNumber, j, true);
                    formQueen(board, rowNumber+1, dim);
                    // BT
                    board[rowNumber][j] = 0;
                    updateForQueen(board, rowNumber, j, false);
                }
            }
        }
    }
}
