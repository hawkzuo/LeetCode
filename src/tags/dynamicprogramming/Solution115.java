//115. Distinct Subsequences

package tags.dynamicprogramming;

public class Solution115 {
   
	
	
	
	
	public int numDistinctSlow(String s, String t) {
        
        
        int m = s.length();
        int n = t.length();
        int [][] sdp=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            sdp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            sdp[0][i] = 0;
        }
        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
            
                //Maintain res of s[i-1] first
                sdp[i][j] = sdp[i-1][j];
                
                //Cal new possible combinations introduced by T[j] comparing with T[j-1]
                if(s.charAt(i-1) == t.charAt(j-1)){
                    sdp[i][j] += sdp[i-1][j-1]; 
                }
            }
        }
        
        return sdp[m][n];
        
        
        
        
    }

}
