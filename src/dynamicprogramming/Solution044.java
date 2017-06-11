//44. Wildcard Matching
//Beats 2.59%

package dynamicprogramming;

public class Solution044 {

    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        int m = c1.length;
        int n = c2.length;
        if(m == 0 && n == 0){   return true;}
        //else if (m == 0 || n == 0){ return false;}
        
        
        int[][] dp = new int[m+1][n+1];
        
        
        int res = getDP(dp,c1,c2,m,n,0,0);
        
        if(res == 1){
            return true;
        }else{  return false;}        
    }
    private boolean validEmpty(char[] c, int j){
        int len = c.length;
        if(j>=len){ return true;}
        
        if(c[j] == '*'){
            return validEmpty(c,j+1);
        }else{
            return false;
        }
        
        
    }    
    private int getDP(int[][] dp, char[] c1,char[] c2,int m, int n, int i, int j){
        
        // Check i,j
        if(i == m){
            
            if(validEmpty(c2,j)){
                dp[i][j] = 1;
            }else{
                dp[i][j] = -1;
            }
            return dp[i][j];
            
            
        }else if(j == n){
            if(i<=m-1){
                dp[i][j] = -1;
            }else{
                dp[i][j] = 1;
            }
            return dp[i][j];
 
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
            char r = c2[j]; 
            char s = c1[i];            
            if(r == '?'){
                dp[i][j] = getDP(dp,c1,c2,m,n,i+1,j+1);
            }else if(r == '*'){
                int cdd = getDP(dp,c1,c2,m,n,i,j+1);
                for(int z=i+1;z<=m;z++){
                    cdd = Math.max(cdd,getDP(dp,c1,c2,m,n,z,j+1));
                }                
                dp[i][j] = cdd;
                
            }else{
                if(r == s){
                    dp[i][j] = getDP(dp,c1,c2,m,n,i+1,j+1);
                }else{
                    dp[i][j] = -1;
                }                
            }
            
            return dp[i][j];

   
    }    
    

}
