//215. Kth Largest Element in an Array

package scatter;

import java.util.Arrays;

public class Solution215 {

    public int findKthLargestBrute(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    public int findKthLargest(int[] nums, int k) {
    	Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
