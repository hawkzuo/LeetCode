package tags.dynamicprogramming;

public class Solution091 {

	public Solution091() {
		// TODO Auto-generated constructor stub
	}
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 ){    return 0;}
        else if(s.length() == 1){ 
            int dummy = s.charAt(0)-'0';
            if(dummy >= 10 || dummy <= 0){  return 0;}
            return 1;
        }        
        char[] str = s.toCharArray();        
        int[] dp = new int[str.length];
        if(checkSingle(str[0]) )	dp[0]=1;
        else	return 0;
        dp[1] = 0;
        if(checkDouble(str[0],str[1])){
            dp[1]++;
            if(checkSingle(str[1]) )	dp[1]++;
        }else if(checkSingle(str[1]) ){	dp[1]++;
        }else{							return 0;
        }
        for(int i=2;i<str.length;i++){        	
        	int curSum = 0;       	
        	if(checkSingle(str[i]) )	curSum += dp[i-1];        	
        	if(checkDouble(str[i-1],str[i])  )	curSum += dp[i-2];
        	if(curSum == 0)    return 0;
        	dp[i] = curSum;
        }
        return dp[str.length-1];
    }
    
    private boolean checkSingle(char input){
        int d = input-'0';
        if(d <= 9 && d >= 1)	return true;
        else	 return false;        
    }
    private boolean checkDouble(char high, char low){
        int hd = high - '0';
        int ld = low -'0';
        if(hd == 1){
            if(ld >=0 && ld<= 9){
                return true;
            }else{
                return false;
            }
        }else if(hd == 2){
            if(ld >=0 && ld<=6){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "13101231012152033";
		Solution091 s = new Solution091()	;
		System.out.println(s.numDecodings(str));
	}    
    
    
    
    
}
