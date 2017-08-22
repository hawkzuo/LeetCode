package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/13.
 * Generate Parentheses
 */
public class Sol022 {
    public List<String> generateParenthesis(int n) {
        // Typical DP use case
        List<String> [] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<>(); dp[0].add("");

        for(int i=1;i<=n;i++){
            dp[i] = new ArrayList<>();
            for(int j=0;j<=i-1;j++){
                for(String leftHalf: dp[j]){
                    for(String rightHalf: dp[i-1-j]){
                        dp[i].add("("+leftHalf+")"+rightHalf);
                    }
                }
            }
        }
        return dp[n];
    }
}
