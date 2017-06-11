//22. Generate Parentheses

package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {

    public List<String> generateParenthesis(int n) {
        
        List<String> [] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<String>(); dp[0].add("");
        
        for(int i=1;i<=n;i++){
            dp[i] = new ArrayList<String>();
            
            for(int j=0;j<=i-1;j++){
                
                for(String lh: dp[j]){
                    for(String rh: dp[i-1-j]){
                        dp[i].add("("+lh+")"+rh);
                    }
                    
                    
                }

            }
            
        }
        
        return dp[n];
        
        
    }

}
