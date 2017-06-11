//10. Regular Expression Matching

package dynamicprogramming;

public class Solution010 {
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
        
        if(j == len-1){
            return false;
        }
        
        char c2=c[j+1];
        if(c2 == '*'){
            return validEmpty(c,j+2);
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
        
        
        if(j+1 <= n-1){
            char r = c2[j]; char f = c2[j+1];
            char s = c1[i];
            
            if(f != '*' && r != '.'){
                
                if(r == s){
                    dp[i][j] = getDP(dp,c1,c2,m,n,i+1,j+1);
                }else{
                    dp[i][j] = -1;
                }
                
            }else if(f != '*' && r == '.'){
                
                dp[i][j] = getDP(dp,c1,c2,m,n,i+1,j+1);
                
            }else if(f == '*' && r != '.'){
                
                if(r != s){
                    dp[i][j] = getDP(dp,c1,c2,m,n,i,j+2);
                }else{
                    dp[i][j] = Math.max(getDP(dp,c1,c2,m,n,i,j+2),getDP(dp,c1,c2,m,n,i+1,j));
                }
            
            }else{
                //Try all combinations
                int cdd = getDP(dp,c1,c2,m,n,i,j+2);
                for(int z=i+1;z<=m;z++){
                    cdd = Math.max(cdd,getDP(dp,c1,c2,m,n,z,j+2));
                }
                dp[i][j] = cdd;
            }
            
            return dp[i][j];
            
            
        }else{
            //j == n-1
            char r = c2[j]; 
            char s = c1[i];            
            if(r == '.'){
                dp[i][j] = getDP(dp,c1,c2,m,n,i+1,j+1);
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


}
