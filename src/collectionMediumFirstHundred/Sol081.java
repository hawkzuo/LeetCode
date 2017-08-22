package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/26.
 * Search in Rotated Sorted Array II
 */
public class Sol081 {
    public boolean search(int[] nums, int target) {
        // Can improve to log(n)
        if(nums.length == 1){	return nums[0] == target;}
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
