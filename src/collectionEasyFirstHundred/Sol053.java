package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Maximum Subarray
 */
public class Sol053 {
    // Idea: DP stores the maximum sub sum including the i-th element in the Array.

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        if(len == 0){   return 0;}

        int [] maxIncludingEndIndex = new int[len];
        maxIncludingEndIndex[0] = nums[0];
        int max = maxIncludingEndIndex[0];
        for(int j=1;j<len;j++){
            if (maxIncludingEndIndex[j-1] > 0) {
                maxIncludingEndIndex[j] = maxIncludingEndIndex[j-1] + nums[j];
            } else {
                maxIncludingEndIndex[j] = nums[j];
            }
            max = Math.max(max, maxIncludingEndIndex[j]);
        }
        return max;
    }
}
