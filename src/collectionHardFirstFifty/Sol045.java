package collectionHardFirstFifty;

import collectionUtils.Sol;

/**
 * Created by Amos on 2017/9/12.
 * Jump Game II
 */
public class Sol045 {
    // Idea: As stated below

    public static void main(String[] args) {
        Sol045 s = new Sol045();
        int[] A = {1,2,3,4,5};
        int[] B = {};

        StringBuilder sb = new StringBuilder();
        System.out.println(s.jump(A));
    }

    // Optimize with a counter, based on the fact that steps are non-decreasing sequences
    // Details in notes
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        // Initialize
        for(int j=1; j<=nums[0]; j++) {
            if(j >= dp.length) {
                break;
            }
            dp[j] = 1;
        }
        // Top is the element to be updated
        int top = nums[0] + 1;
        int bottom = 1;

        while(top < nums.length) {
            if(bottom + nums[bottom] >= top) {
                // Refresh minimal steps required
                for(int j=top; j<= bottom + nums[bottom]; j++) {
                    if(j >= dp.length) {
                        break;
                    }
                    dp[j] = 1 + dp[bottom];
                }
                top = bottom + nums[bottom] + 1;
            } else {
                // No need to update optimal values
                bottom ++;
            }
        }

        return dp[dp.length-1];
    }


    // Bottom-up DP: TLE
    public int jumpBottomUp(int[] nums) {

        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;

        for(int j=nums.length-2; j>=0; j--) {
            int steps = nums[j];
            // DP process
            int res = Integer.MAX_VALUE;
            for(int i=j+1; i<=j+steps; i++) {
                int next;
                if(i>= nums.length -1) {
                    next = 0;
                } else {
                    next = dp[i];
                }
                res = Math.min(res, next);
            }
            if(res == Integer.MAX_VALUE) {
                dp[j] = Integer.MAX_VALUE;
            } else {
                dp[j] = res + 1;
            }

        }
        return dp[0];
    }


    // Top-down DP: stack-overflow
    public int jumpTop(int[] nums) {

        int[] dp = new int[nums.length];
        return getDist(nums, 0, dp);

    }


    private int getDist(int[] A, int pos, int[] dp) {

        // Base case1:
        if(pos >= A.length -1) {
            return 0;
        }
        if(dp[pos] != 0) {
            return dp[pos];
        }

        int res = Integer.MAX_VALUE;
        int steps = A[pos];

        for(int i=1; i<=steps; i++) {
            res = Math.min(res, getDist(A, pos+i, dp));
        }

        if(res == Integer.MAX_VALUE) {
            dp[pos] = Integer.MAX_VALUE;
        } else {
            dp[pos] = res + 1;
        }
        return dp[pos];
    }



}
