package collectionMedium;

/**
 * Created by Amos on 2017/7/26.
 * Word Search
 */
public class Sol079 {
    boolean globalFlag = false;
    public boolean exist(char[][] board, String word) {

        globalFlag = false;
        if(board==null || word==null || board.length==0 || word.length()==0){   return false;}
        boolean[][] visited = new boolean[board.length][board[0].length];

        int curLength = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                bruteSearch(board,visited,i,j,word,curLength);
                if(globalFlag){
                    return globalFlag;
                }
            }
        }
        return globalFlag;
    }
    private void bruteSearch(char[][] board, boolean[][] visited, int x, int y, String input, int curListLength){
        int m=board.length; int n=board[0].length;
        // Corners
        if(x < 0 || x>=m || y<0 || y>=n || visited[x][y]){   return;}
        // Stop extra work
        if(globalFlag){ return;}
        // Add (x,y) to path first, mark visited,
        visited[x][y] = true;
        if(board[x][y] == input.charAt(curListLength)){
            if(input.length() == curListLength+1 ){
                globalFlag = true;
            }else{
                bruteSearch(board,visited,x+1,y,input,curListLength+1);
                bruteSearch(board,visited,x-1,y,input,curListLength+1);
                bruteSearch(board,visited,x,y+1,input,curListLength+1);
                bruteSearch(board,visited,x,y-1,input,curListLength+1);
            }
        }
        // BT    remove current char from the path && clean up the visited flags
        visited[x][y] = false;
    }
}
