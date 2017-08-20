//264. Ugly Number II

package tags.dynamicprogramming;

public class Solution264 {
	private int[] dp = new int[1691];
	
    public int nthUglyNumber(int n) {
        if(dp[n]!=0){	return dp[n];}
        
        dp[1] = 1;
        int p2=1;   int p3=1;   int p5=1;
        
        for(int i=2;i<=n;i++){
            int val = Math.min(2*dp[p2],Math.min(3*dp[p3],5*dp[p5]));
            dp[i] = val;
            if(2*dp[p2] == val){    p2++;}
            if(3*dp[p3] == val){    p3++;}
            if(5*dp[p5] == val){    p5++;}
        }
        
        return dp[n];
        
    }
	public static void main(String[] args) {
		Solution264 s =new Solution264();
		System.out.print(s.nthUglyNumber(1));
		String t="";
		t.charAt(0);
	}

}
