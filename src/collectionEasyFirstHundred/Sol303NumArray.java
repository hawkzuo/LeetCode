package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Range Sum Query - Immutable
 */
public class Sol303NumArray {
    // Idea: Pre-fix routine, store dp table
    private int [] dp;
    public Sol303NumArray(int[] nums) {
        dp = new int[nums.length+1];
        int cur=0;
        for(int i=0;i<nums.length;i++){
            cur += nums[i];
            dp[i+1] = cur;
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}
