package collectionMedium;

/**
 * Created by Amos on 2017/7/23.
 * Sort Colors
 */
public class Sol075 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int cur = 0;

        // cur is the index of the first available position
        // 'available' means value is not 0/1
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                // swap '0' to the beginning
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
                cur++;
            }
        }
        for(int i = cur; i < nums.length; i++) {
            if(nums[i] == 1) {
                // swap '1' to the beginning
                int tmp = nums[cur];
                nums[cur] = nums[i];
                nums[i] = tmp;
                cur++;
            }
        }
    }
}
