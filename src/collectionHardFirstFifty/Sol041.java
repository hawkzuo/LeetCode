package collectionHardFirstFifty;

/*
 * Created by Amos on 10/24/17.
 */
public class Sol041 {

    // Idea: Use Array As Hash
    // Notice the Index Range
    // 34-11
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        int upper = nums.length;

        for(int i=0; i<nums.length; i++) {
            int step = nums[i];
            while(step <= upper && step>=1 && nums[step-1] != step) {
                int tmp = nums[step-1];
                nums[step-1] = step;
                step = tmp;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return upper+1;

    }
}
