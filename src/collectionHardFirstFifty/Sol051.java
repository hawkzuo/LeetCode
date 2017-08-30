package collectionHardFirstFifty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/29.
 * N-Queens
 */
public class Sol051 {
    // Why use int[][] ?
    // value == 0 => available
    // value == -1 => Queen
    // value > 0 => # of Queens can reach this position

    // Idea: The reason why previous is TLE is no order is maintained, the next position is generated randomly
    // To solve this issue, use specific control flow of adding queens
    // Notice that the answer must be one in each row/col if exists

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        putQueen(board, 0, result, n);
        return result;
    }
    private void storeBoard(int[][] board, List<List<String>> result) {
        List<String> dummy = new ArrayList<>();
        for (int[] rowBoard : board) {
            StringBuilder rowString = new StringBuilder();
            for (int rowColElement : rowBoard) {
                rowString.append(rowColElement == -1 ? 'Q' : '.');
            }
            dummy.add(rowString.toString());
        }
        result.add(dummy);
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

    private void putQueen(int[][] board, int rowNumber, List<List<String>> result, int dim) {
        // Base case
        if(rowNumber == dim-1) {
            for(int j=0;j<dim; j++) {
                if(board[rowNumber][j] == 0) {
                    // Modify & store
                    board[rowNumber][j] = -1;
                    storeBoard(board,  result);
                    board[rowNumber][j] = 0;
                }
            }
        } else {
            // Row by row put queen
            for(int j=0; j<dim; j++) {
                if(board[rowNumber][j] == 0) {
                    // Update values below this row
                    board[rowNumber][j] = -1;
                    updateForQueen(board, rowNumber, j, true);
                    putQueen(board, rowNumber+1, result, dim);
                    // BT
                    board[rowNumber][j] = 0;
                    updateForQueen(board, rowNumber, j, false);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sol051 s = new Sol051();
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        System.out.println(s.solveNQueens(5));
    }

}
