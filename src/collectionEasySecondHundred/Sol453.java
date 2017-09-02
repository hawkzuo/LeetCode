package collectionEasySecondHundred;

/**
 * Created by Amos on 2017/9/2.
 * Minimum Moves to Equal Array Elements
 */
public class Sol453 {
    // Idea: Pic453 will show the process
    // Actually Ans = Sum(A) - Min(A), so can be done in one pass, but it's okay for now
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 1){   return 0;   }
        int minimal = getMin(nums);
        int result = 0;
        for(int i: nums) {
            result += i-minimal;
        }
        return result;
    }

    private int getMin(int[] input) {
        int res = input[0];
        for(int i=1;i<input.length;i++) {
            res = Math.min(res, input[i]);
        }
        return res;
    }
}
