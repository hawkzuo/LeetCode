package collectionMediumThirdHundred;

import java.util.Arrays;

/**
 * Created by Amos on 2017/9/2.
 * Minimum Moves to Equal Array Elements II
 */
public class Sol462 {
    // Idea: Pic462 will show the process
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0) {  return 0; }
        Arrays.sort(nums);
        int midIndex = nums.length / 2; int mid = nums[midIndex];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}
