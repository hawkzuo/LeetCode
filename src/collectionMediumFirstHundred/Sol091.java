package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/26.
 * Decode Ways
 */
public class Sol091 {
    public int numDecodings(String s) {
        // Corner cases
        if(s == null || s.length() == 0 ){    return 0;}
        else if(s.length() == 1){
            int dummy = s.charAt(0)-'0';
            if(dummy >= 10 || dummy <= 0){  return 0;}
            return 1;
        }

        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        if(canDecodeAsSingle(str[0]) ){
            dp[0]=1;
        }else{
            // Failed on the first char, return 0
            return 0;
        }
        dp[1] = 0;
        if(canDecodeAsDouble(str[0],str[1])){
            dp[1]++;
            if(canDecodeAsSingle(str[1]) ){
                dp[1]++;
            }
        }else if(canDecodeAsSingle(str[1]) ){
            dp[1]++;
        }else{
            // Failed on the second char, return 0
            return 0;
        }

        // Bottom up DP
        for(int i=2;i<str.length;i++){
            // Sub-problem is D[n] = D[i-1] + D[i-2]
            int curSum = 0;
            if(canDecodeAsSingle(str[i]) ){
                curSum += dp[i-1];
            }
            if(canDecodeAsDouble(str[i-1],str[i])  ){
                curSum += dp[i-2];
            }
            // Optimization for sad path
            if(curSum == 0){    return 0;}
            dp[i] = curSum;
        }
        return dp[str.length-1];
    }

    private boolean canDecodeAsSingle(char input){
        int d = input-'0';
        return d <= 9 && d >= 1;
    }
    private boolean canDecodeAsDouble(char high, char low){
        int hd = high - '0';
        int ld = low -'0';
        if(hd == 1){
            return ld >= 0 && ld <= 9;
        }else if(hd == 2){
            return ld >= 0 && ld <= 6;
        }else{
            return false;
        }
    }
}
