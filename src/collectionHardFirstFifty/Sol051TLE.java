package collectionHardFirstFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Amos on 2017/8/29.
 * N-Queens
 */

final class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Sol051TLE {
    // Idea: No idea, try them all Brute-force very slow
    // Reason: Use Hash randomly choose next position   => duplicates exist
    // In reality, just row by row adding will do

    public List<List<String>> solveNQueens(int n) {
        Set<String> result = new HashSet<>();
        // Initialized value is 0
        int[][] board = new int[n][n];
        Pair[][] refer = new Pair[n][n];
        Set<Pair> availableChoices = new HashSet<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                refer[i][j] = new Pair(i, j);
                availableChoices.add(refer[i][j]);
            }
        }

        putQueen(board, refer, availableChoices, n, result);
        List<List<String>> ans = new ArrayList<>();
        for(String table: result) {
            List<String> dummy = new ArrayList<>();
            for(int i=0;i<n;i++) {
                dummy.add(table.substring(i * n, n + i*n));
            }
            ans.add(dummy);
        }
        return ans;
    }
    private void storeBoard(int[][] board, Set<String> result) {
        StringBuilder boardString = new StringBuilder();
        for (int[] rowBoard : board) {
            for (int rowColElement : rowBoard) {
                boardString.append(rowColElement == -1 ? 'Q' : '.');
            }
        }
        result.add(boardString.toString());
    }

    private void updateHelper(int x, int y, int[][] board, Pair[][] refer, Set<Pair> nextLevel) {
        if(board[x][y] == -1) { return;}
        if(board[x][y] == 0) {
            board[x][y] = 1;
            nextLevel.remove(refer[x][y]);
        } else {
            board[x][y] += 1;
        }
    }

    private Set<Pair> updateAfterAddQueen(int[][] board, Pair[][] refer, Set<Pair> availableChoices, int x, int y) {
        Set<Pair> nextLevel = new HashSet<>(availableChoices);
        board[x][y] = -1;    int n=board.length;
        nextLevel.remove(refer[x][y]);
        // Remove all positions this queen can reach
        // Cols
        for(int i=0;i<n;i++) {
            if(i == x) {    continue;}
            updateHelper(i, y, board, refer, nextLevel);
        }
        // Rows
        for(int i=0;i<n;i++) {
            if(i == y) {    continue;}
            updateHelper(x, i, board, refer, nextLevel);
        }
        // Diagonals
        int startX = x; int startY = y;
        while(startX+1 < n && startY+1 < n) {
            startX ++;  startY++;
            updateHelper(startX, startY, board, refer, nextLevel);
        }
        startX = x; startY = y;
        while(startX+1 < n && startY-1 >= 0) {
            startX++; startY--;
            updateHelper(startX, startY, board, refer, nextLevel);
        }
        startX = x; startY = y;
        while(startX-1 >= 0 && startY-1 >= 0) {
            startX--; startY--;
            updateHelper(startX, startY, board, refer, nextLevel);
        }
        startX = x; startY = y;
        while(startX-1 >=0 && startY+1 < n) {
            startX--; startY++;
            updateHelper(startX, startY, board, refer, nextLevel);
        }
        return nextLevel;
    }

    private void refreshAtBackward(int[][] board, int x, int y) {
        // BT is faster, just minus 1 on every reachable point
        board[x][y] = 0;    int n=board.length;
        // Cols
        for(int i=0;i<n;i++) {
            if(i == x || board[i][y] == -1) {    continue;}
            board[i][y] -= 1;
        }
        // Rows
        for(int i=0;i<n;i++) {
            if(i == y || board[x][i] == -1) {    continue;}
            board[x][i] -= 1;
        }
        // Diagonals
        int startX = x; int startY = y;
        while(startX+1 < n && startY+1 < n) {
            startX ++;  startY++;
            if(board[startX][startY] == -1) { continue;}
            board[startX][startY] -= 1;
        }
        startX = x; startY = y;
        while(startX+1 < n && startY-1 >= 0) {
            startX++; startY--;
            if(board[startX][startY] == -1) { continue;}
            board[startX][startY] -= 1;
        }
        startX = x; startY = y;
        while(startX-1 >= 0 && startY-1 >= 0) {
            startX--; startY--;
            if(board[startX][startY] == -1) { continue;}
            board[startX][startY] -= 1;
        }
        startX = x; startY = y;
        while(startX-1 >=0 && startY+1 < n) {
            startX--; startY++;
            if(board[startX][startY] == -1) { continue;}
            board[startX][startY] -= 1;
        }
    }

    private void putQueen(int[][] board, Pair[][] refer, Set<Pair> availableChoices, int queensToAdd, Set<String> result ) {
        // Base case
        if(queensToAdd == 1) {
            if(availableChoices.size() > 0) {
                for(Pair position: availableChoices) {
                    int Px = position.x;
                    int Py = position.y;
                    board[Px][Py] = -1;
                    storeBoard(board, result);
                    board[Px][Py] = 0;
                }
            }
        } else {
            // Try all the possible solutions
            for(Pair pos: availableChoices) {
                int Px = pos.x;
                int Py = pos.y;
                // Make copy of availableChoices
                Set<Pair> nextLevel = updateAfterAddQueen(board, refer, availableChoices, Px, Py);
                putQueen(board, refer, nextLevel, queensToAdd-1, result);
                // BT
                refreshAtBackward(board, Px, Py);
            }
        }
    }


    public static void main(String[] args) {
        Sol051TLE s = new Sol051TLE();
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        System.out.println(s.solveNQueens(8));
    }

}
