//130. Surrounded Regions

package breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution130 {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0){   return; }
        int col = board[0].length;
        
        for(int i=0;i<col;i++){
            markSurvive(board, 0,i);
            markSurvive(board, row-1,i);
        }
        for(int j=0;j<row;j++){
            
            markSurvive(board, j,0);
            markSurvive(board, j,col-1);
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(board[j][i] == 'O'){
                    board[j][i] = 'X';
                }else if(board[j][i] == 'S'){
                    board[j][i] = 'O';
                }
            }
        }        
    }
    private void markSurvive(char[][] board, int x, int y){
        if(board[x][y] != 'O'){ return;}      
        Deque<Cor> stack = new ArrayDeque<Cor>();
        stack.add(new Cor(x,y));        

        while(!stack.isEmpty()){
            int times = stack.size();
            for(int i=0;i<times;i++){
                Cor current = stack.remove();
                 
                Cor nb1 = new Cor(current.x-1,current.y);
                Cor nb2 = new Cor(current.x+1,current.y);
                Cor nb3 = new Cor(current.x,current.y-1);
                Cor nb4 = new Cor(current.x,current.y+1);

                if(perform(nb1,board)){
                	stack.add(nb1);
                }
                if(perform(nb2,board)){
                    stack.add(nb2);
                }                
                if(perform(nb3,board)){
                    stack.add(nb3);
                }                
                if(perform(nb4,board)){
                    stack.add(nb4);
                }              
            }
        }        
        

    }
    private boolean perform(Cor cur,char[][] rooms){
        int r1=rooms.length;
        int c1=rooms[0].length;   
        int x = cur.x;
        int y = cur.y;
        if(x>=0 && x<r1 && y>=0 && y<c1){
            if(rooms[x][y] == 'S'){
	            return true;
            }else if(rooms[x][y] == 'O'){
            	rooms[x][y] = 'S';
            	return true;
            }
        }
        return false;
        
    }	
	
	public void solveACDFS(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		if (board.length < 2 || board[0].length < 2)
			return;
		int m = board.length, n = board[0].length;
		//Any 'O' connected to a boundary can't be turned to 'X', so ...
		//Start from first and last column, turn 'O' to '*'.
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				boundaryDFS(board, i, 0);
			if (board[i][n-1] == 'O')
				boundaryDFS(board, i, n-1);	
		}
		//Start from first and last row, turn '0' to '*'
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				boundaryDFS(board, 0, j);
			if (board[m-1][j] == 'O')
				boundaryDFS(board, m-1, j);	
		}
		//post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}
	//Use DFS algo to turn internal however boundary-connected 'O' to '*';
	private void boundaryDFS(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
			return;
		if (board[i][j] == 'O')
			board[i][j] = '*';
		if (i > 1 && board[i-1][j] == 'O')
			boundaryDFS(board, i-1, j);
		if (i < board.length - 2 && board[i+1][j] == 'O')
			boundaryDFS(board, i+1, j);
		if (j > 1 && board[i][j-1] == 'O')
			boundaryDFS(board, i, j-1);
		if (j < board[i].length - 2 && board[i][j+1] == 'O' )
			boundaryDFS(board, i, j+1);
	}    
	
	public void solveOverflow(char[][] board) {
        int row = board.length;
        if(row == 0){   return; }
        int col = board[0].length;
        
        for(int i=0;i<col;i++){
            markSurvive2(board, 0,i);
            markSurvive2(board, row-1,i);
        }
        for(int j=0;j<row;j++){
            
            markSurvive2(board, j,0);
            markSurvive2(board, j,col-1);
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(board[j][i] == 'O'){
                    board[j][i] = 'X';
                }else if(board[j][i] == 'S'){
                    board[j][i] = 'O';
                }
            }
        }
        
        
    }
    private void markSurvive2(char[][] board, int x, int y){
        int row = board.length;        
        int col = board[0].length;
        
        if(!checkValid(x,y,row,col)){
            return;
        }else{
            if(board[x][y] == 'O'){
                board[x][y] = 'S';
                markSurvive(board,x-1,y);
                markSurvive(board,x+1,y);
                markSurvive(board,x,y-1);
                markSurvive(board,x,y+1);
            }else{
                return;
            }
        }
    }
    private boolean checkValid(int x,int y,int r, int c){
        if(x>=0 && x<r && y>=0 && y<c){
            return true;
        }
        return false;
    }

}
