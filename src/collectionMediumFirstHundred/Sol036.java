package collectionMediumFirstHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Valid Sudoku
 */
public class Sol036 {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){ return false;}
        //Check rows and cols
        for(int r=0;r<9;r++){
            Set<Character> container = new HashSet<>();
            for(int c=0;c<9;c++){
                char ch = board[r][c];
                if (ch != '.') {
                    if(!isValidChar(ch)){ return false;}
                    else{
                        if(container.contains(ch)){
                            return false;
                        }else{
                            container.add(ch);
                        }
                    }
                }
            }
        }
        for(int c=0;c<9;c++){
            Set<Character> container = new HashSet<>();
            for(int r=0;r<9;r++){
                char ch = board[r][c];
                if (ch != '.') {
                    if(!isValidChar(ch)){ return false;}
                    else{
                        if(container.contains(ch)){
                            return false;
                        }else{
                            container.add(ch);
                        }
                    }
                }
            }
        }
        // check blocks
        for(int x=0;x<9;x+=3) {
            for(int y=0;y<9;y+=3){
                Set<Character> container = new HashSet<>();
                for(int offsetX=0;offsetX<=2;offsetX++){
                    for(int offsetY=0;offsetY<=2;offsetY++){
                        char ch = board[x+offsetX][y+offsetY];
                        if (ch != '.') {
                            if(!isValidChar(ch)){ return false;}
                            else{
                                if(container.contains(ch)){
                                    return false;
                                }else{
                                    container.add(ch);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidChar(char input) {
        int offset = input - '0';
        return offset >= 1 && offset <= 9;
    }
}
