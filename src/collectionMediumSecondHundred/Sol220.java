package collectionMediumSecondHundred;

import java.util.TreeSet;

/**
 * Created by Amos on 2017/8/22.
 * Contains Duplicate III
 */
public class Sol220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Brute Time: O(Nk)
        // Idea: Sliding Window
        //       TreeSet stores at most k elements
        //       For each A[i], check its floor and ceil in the Set and see if there exists
        //       elements of Set satisfies value \in [A[i]-t, A[i]+t]
        // Running Time: O(Nlogk)
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int index = 0; index < nums.length; index++) {
            final Long floor = values.floor( (long)nums[index] + (long)t);
            final Long ceil = values.ceiling((long)nums[index] - (long)t);
            if ( (floor != null && floor >= nums[index]) || (ceil != null && ceil <= nums[index]) ) {
                return true;
            }
            // Move one step on the window
            values.add((long) nums[index]);
            if (index >= k) {
                values.remove((long)nums[index - k]);
            }
        }
        return false;
    }
}
