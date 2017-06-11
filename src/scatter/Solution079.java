package scatter;

public class Solution079 {

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
    private void bruteSearch(char[][] board,boolean[][] visited, int x, int y, String input, int cursor){
        int m=board.length; int n=board[0].length;
        if(x < 0 || x>=m || y<0 || y>=n || visited[x][y]){   return;}
        //Stop extra work
        if(globalFlag == true){ return;}
        //Add (x,y) to path first, mark visited, 
        visited[x][y] = true;
        if(board[x][y] == input.charAt(cursor)){
            if(input.length() == cursor+1 ){
                globalFlag = true;
            }else{
                bruteSearch(board,visited,x+1,y,input,cursor+1);
                bruteSearch(board,visited,x-1,y,input,cursor+1);
                bruteSearch(board,visited,x,y+1,input,cursor+1);
                bruteSearch(board,visited,x,y-1,input,cursor+1);                   
            }
        }
        //BT    remove current char from the path && clean up the visited flags
        visited[x][y] = false;
    }  

}
