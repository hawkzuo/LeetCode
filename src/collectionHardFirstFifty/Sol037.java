package collectionHardFirstFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/9/7.
 * Sudoku Solver
 */
public class Sol037 {
    // Idea: Element-by-element checking, and then take care of the Core reminders

    public void solveSudoku(char[][] board) {
        // Use three sets to store the current chosen elements for O(1) querying
        Set[] rows = new HashSet[10];
        Set[] cols = new HashSet[10];
        Set[] towns = new HashSet[10];
        for(int i=0; i< 10; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            towns[i] = new HashSet<Character>();
        }
        // Initialize
        for(int i=0; i< 9; i++) {
            for(int j=0; j<9; j++) {
                char step = board[i][j];
                if(step != '.') {
                    int townNum = getTownNumber(i, j);
                    rows[i].add(step);  cols[j].add(step);  towns[townNum].add(step);
                }
            }
        }
        // BT searching process
        fillBoard(0, 0, board, rows, cols, towns);
    }

    // Main-Process
    private boolean fillBoard(int x, int y, char[][] board, Set[] rows, Set[] cols, Set[] towns) {
        if(x >= 9) {    return true; }

        if(board[x][y] != '.') {
            // Core2: Must return boolean on each sub-routine
            // Move to right neighbor or first element of the next line
            return y == 8 ? fillBoard(x + 1, 0, board, rows, cols, towns) : fillBoard(x, y + 1, board, rows, cols, towns);
        } else {
            // Try all the possible chars
            for(char next = '1'; next <= '9'; next++) {
                if (!rows[x].contains(next) && !cols[y].contains(next) && !towns[getTownNumber(x, y)].contains(next)) {
                    board[x][y] = next;
                    rows[x].add(next);  cols[y].add(next); towns[getTownNumber(x, y)].add(next);
                    boolean res = y == 8 ?
                            fillBoard(x + 1, 0, board, rows, cols, towns) :
                            fillBoard(x, y + 1, board, rows, cols, towns);
                    // BT
                    if (res) {
                        return true;
                    } else {
                        // Core1: Must make board look exactly the same as before, otherwise this cell will be skipped
                        board[x][y] = '.';
                        rows[x].remove(next);   cols[y].remove(next); towns[getTownNumber(x,y)].remove(next);
                    }
                }
            }
            return false;
        }
    }

    //  1   2   3
    //  4   5   6
    //  7   8   9
    private int getTownNumber(int x, int y) {
        if(y <= 2 ) {
            if(x <= 2) {
                return 1;
            } else if(x <= 5) {
                return 4;
            } else {
                return 7;
            }
        } else if(y <= 5) {
            if(x <= 2) {
                return 2;
            } else if(x <= 5) {
                return 5;
            } else {
                return 8;
            }
        } else {
            if(x <= 2) {
                return 3;
            } else if(x <= 5) {
                return 6;
            } else {
                return 9;
            }
        }


    }

    public static void main(String[] args) {
        Sol037 s = new Sol037();
        char[][] board = {  "..9748...".toCharArray(),"7........".toCharArray(),
                            ".2.1.9...".toCharArray(),"..7...24.".toCharArray(),
                            ".64.1.59.".toCharArray(),".98...3..".toCharArray(),
                            "...8.3.2.".toCharArray(),"........6".toCharArray(),
                            "...2759..".toCharArray()};
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        s.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }



}
