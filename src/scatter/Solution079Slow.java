package scatter;

public class Solution079Slow {

    boolean globalFlag = false;
    public boolean exist(char[][] board, String word) {
        
        globalFlag = false;
        if(board==null || word==null || board.length==0 || word.length()==0){   return false;}
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        StringBuilder sb = new StringBuilder();
    	for(int i=0;i<board.length;i++){
    	    for(int j=0;j<board[0].length;j++){
    	        bruteSearch(board,visited,i,j,sb,word);
    	        if(globalFlag){
    	            return globalFlag;
    	        }
    	    }
    	} 
    	return globalFlag;
    }
    private void bruteSearch(char[][] board,boolean[][] visited, int x, int y, StringBuilder path, String input){
        int m=board.length; int n=board[0].length;
        if(x < 0 || x>=m || y<0 || y>=n || visited[x][y]){   return;}
        //Stop extra work
        if(globalFlag == true){ return;}
        //Add (x,y) to path first, mark visited, 
        path.append(board[x][y]);
        visited[x][y] = true;
        String str = path.toString();
        //Then check for the Trie for corresponding word
        if(startsWith(input,str) ){
            if(input.length() == str.length() ){
                //There's a corresponding here.
                globalFlag = true;
            }else{
                bruteSearch(board,visited,x+1,y,path,input);
                bruteSearch(board,visited,x-1,y,path,input);
                bruteSearch(board,visited,x,y+1,path,input);
                bruteSearch(board,visited,x,y-1,path,input);            
            }
        }
        
        //BT    remove current char from the path && clean up the visited flags
        path.deleteCharAt(path.length()-1);
        visited[x][y] = false;
    }    
    
    private boolean startsWith(String slong, String sshort){
        char[] lc = slong.toCharArray();
        char[] sc = sshort.toCharArray();
        if(lc.length < sc.length){  return false;}
        for(int i=0;i<sc.length;i++){
            if(sc[i] != lc[i]){
                return false;
            }
        }
        return true;
    }

}
