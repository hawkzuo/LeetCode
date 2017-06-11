//97. Interleaving String

package dynamicprogramming;

public class Solution097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        
        int m=s1.length();
        int n=s2.length();
        
        int k=s3.length();
        
        if(k != m+n){   return false;}
        
        int[][] dp = new int[m+1][n+1];
        
        dp[m][n] = 1;
        
        char[] str = s3.toCharArray();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int res = getDP(0,0,c1,c2,str,dp);        
        
        if(res == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
    private int getDP(int i,int j,char[] c1, char[] c2, char [] s,int[][] dp){
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        //Two corner cases
        if(i == c1.length){
            if(s[i+j] == c2[j]){
                dp[i][j] = getDP(i,j+1,c1,c2,s,dp);                
            }else{
                dp[i][j] = -1;
            }
            return dp[i][j];
        }else if(j==c2.length){
                if(s[i+j] == c1[i]){                    
                    dp[i][j] = getDP(i+1,j,c1,c2,s,dp);                    
                }else{
                    dp[i][j] = -1;                  
                }        
                return dp[i][j];                
        //Main DP process    
        }else{            
            if(c1[i] != c2[j]){
                if(s[i+j] == c1[i]){                    
                    dp[i][j] = getDP(i+1,j,c1,c2,s,dp);   
                }else if(s[i+j] == c2[j]){                   
                    dp[i][j] = getDP(i,j+1,c1,c2,s,dp);
                }else{                   
                    dp[i][j] = -1;
                }
            }else{           
                if(s[i+j] == c1[i]){                    
                    dp[i][j] = Math.max(getDP(i+1,j,c1,c2,s,dp),getDP(i,j+1,c1,c2,s,dp));                    
                }else{                   
                    dp[i][j] = -1; 
                }                             
            }  
            return dp[i][j];  
        }
    
        
    }
    
    
    
    
    
}
