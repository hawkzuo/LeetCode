//289. Game of Life
//CS 61B pj1 Sharks    287

package collectionACompanies.microsoft;

public class Solution289 {

	public Solution289() {
		// TODO Auto-generated constructor stub
	}

//To do it in-place. Store info inside the matrix while scanning it.

//Then use the hidden info to retrieve next step	
	
    public void gameOfLife(int[][] board) {
        
    	int row = board.length;
    	if(row == 0){ return;  		}
    	int col = board[0].length;
    	
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){   			
    			int Nbs = getNeighbor(board,i,j);
    			board[i][j] = calValue(board[i][j],Nbs);    			
    		}    		
    	}
    	//Convert back
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			if(board[i][j] == 11){
    				board[i][j] = 0;
    			}else if(board[i][j] == 10){
    				board[i][j] = 1;
    			}    			
    		}    		    		
    	}
    	
    	
    }	
    private int calValue(int old, int neighbors){
    	if(old == 1){
    		if(neighbors == 2 || neighbors == 3){
    			//No change
    			return old;
    		}else{
    			//Make a change
    			return old+10;
    		}
    	}else if(old == 0){
    		if(neighbors == 3){
    			//make a change
    			return old+10;
    		}else{
    			//No change
    			return old;
    		}
    		
    		
    	}else{
    		//Error sentinel
    		return -1;
    	}
    	
    	
    }
    private int processValue(int old){
    	if(old > 1){
    		old -= 10;
    	}
    	return old;
    }
    
    private int getNeighbor(int[][] a, int i, int j){    	
    	int up = i-1;	int down = i+1;
    	int left = j-1; int right = j+1;    	
    	int res = 0;    	
    	res += getval(a,up,left);
    	res += getval(a,up,j);
    	res += getval(a,up,right);
    	res += getval(a,i,left);
    	res += getval(a,i,right);
    	res += getval(a,down,left);
    	res += getval(a,down,j);
    	res += getval(a,down,right);
    	//a[up][left] a[up][j] a[up][right]
    	//a[i][left]			 a[i][right]
    	//a[down][left] a[down][j] a[down][right]   	
    	return res;
    	
    }
    private int getval(int[][] a, int x, int y){
    	if(x>=0 && x<=a.length-1 && y>=0 && y<=a[0].length-1){
    		return processValue(a[x][y]);
    	}else{
    		return 0;
    	}
    }
 
//Circle version:
    public void gameOfLifeCircle(int[][] board) {        
    	int row = board.length;
    	if(row == 0){ return;  		}
    	int col = board[0].length;
    	
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){   			
    			int Nbs = getNeighborCircle(board,i,j);
    			board[i][j] = calValue(board[i][j],Nbs);    			
    		}    		
    	}
    	//Convert back
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			if(board[i][j] == 11){
    				board[i][j] = 0;
    			}else if(board[i][j] == 10){
    				board[i][j] = 1;
    			}    			
    		}    		    		
    	}   	
    }    
    
    
    private int getNeighborCircle(int[][] a, int i, int j){    	
    	int up = i-1;	int down = i+1;
    	int left = j-1; int right = j+1;    	
    	int res = 0;    	
    	res += getval2(a,up,left);
    	res += getval2(a,up,j);
    	res += getval2(a,up,right);
    	res += getval2(a,i,left);
    	res += getval2(a,i,right);
    	res += getval2(a,down,left);
    	res += getval2(a,down,j);
    	res += getval2(a,down,right);
    	//a[up][left] a[up][j] a[up][right]
    	//a[i][left]			 a[i][right]
    	//a[down][left] a[down][j] a[down][right]   	
    	return res;
    	
    }
    private int getval2(int[][] a, int x, int y){
    	if(x == -1){
    		x = a.length-1;
    	}else if(x == a.length){
    		x = 0;
    	}else{
    		return -1;
    	}
    	if(y == -1){
    		y = a[0].length-1;
    	}else if(y == a[0].length){
    		y = 0;
    	}else{
    		return -1;
    	}
    	return processValue(a[x][y]);
    }    
    
    
    
}
