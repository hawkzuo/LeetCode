//70. Climbing Stairs

package dynamicprogramming;

public class Solution070 {

    public int climbStairs(int n) {
        int[] dict= new int[n+1];
        return countWays(dict,n);
    }
    private int countWays(int[] dict, int n){
        if(dict[n]!=0){
            return dict[n];
        }
        if(n<=0){   return 0;}
        if(n==1){   
            dict[n]=1; 
            return 1;
        }
        if(n==2){
            dict[n]=2;
            return 2;
        }
        int cur = countWays(dict,n-1)+countWays(dict,n-2);
        dict[n]=cur;
        return cur;
    }

}
