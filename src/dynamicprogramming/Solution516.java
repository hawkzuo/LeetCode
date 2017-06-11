package dynamicprogramming;

public class Solution516 {
 
	/**
		input = "bbbasdkoeksdowiejfpqwe[ib"
		ans = 7
	
	*/

	public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }else if (s.length() == 1){
            return 1;
        }
        
        
        int n = s.length();
        int[][] L = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            L[i][i] = 1;
        }
        
        
        int res = get(L,s,1,n);   
        return res;
    }
    
    public int get(int[][] L, String s, int start, int end){
        if(L[start][end] > 0){
            return L[start][end];
        }
        
        if(s.charAt(start-1) == s.charAt(end-1)){
            if(end == start + 1){
                L[start][end] = 2;
                return L[start][end];
            }else{
                int cur = get(L,s,start+1,end-1)+2;
                L[start][end] = cur;
                return L[start][end];
            }
            
        }else{
            int cur = Math.max(get(L,s,start+1,end),get(L,s,start,end-1) );
                L[start][end] = cur;
                return L[start][end];            
        }
        
        
    }
    
}