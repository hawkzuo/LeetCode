package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();  
        if(board==null || words==null || board.length==0 || words.length==0) return new ArrayList<String>(res);  
        boolean[][] visited = new boolean[board.length][board[0].length];                  
    	Trie tr = new Trie();
    	for(String str:words){
    	    tr.insert(str);
    	}    	
    	StringBuilder sb = new StringBuilder();    	
    	for(int i=0;i<board.length;i++){
    	    for(int j=0;j<board[0].length;j++){
    	        bruteSearch(board,tr,visited,i,j,res,sb);
    	    }
    	}   	
    	return new ArrayList<String>(res);
    }
    
    private void bruteSearch(char[][] board, Trie tr,boolean[][] visited, int x, int y, Set<String> res, StringBuilder path){
        int m=board.length; int n=board[0].length;
        if(x < 0 || x>=m || y<0 || y>=n || visited[x][y]){   return;}        
        //Add (x,y) to path first, mark visited, 
        path.append(board[x][y]);
        visited[x][y] = true;
        String str = path.toString();
        //Then check for the Trie for corresponding word
        if(tr.startsWith(str) ){
            if(tr.search(str) ){
                //There's a corresponding here.
                res.add(str);
            }           
            bruteSearch(board,tr,visited,x+1,y,res,path);
            bruteSearch(board,tr,visited,x-1,y,res,path);
            bruteSearch(board,tr,visited,x,y+1,res,path);
            bruteSearch(board,tr,visited,x,y-1,res,path);
        }        
        //BT    remove current char from the path && clean up the visited flags
        path.deleteCharAt(path.length()-1);
        visited[x][y] = false;
    }

}
