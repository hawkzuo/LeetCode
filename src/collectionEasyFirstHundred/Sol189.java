package collectionEasyFirstHundred;

import java.util.Arrays;

/**
 * Created by Amos on 2017/8/27.
 * Rotate Array
 */
public class Sol189 {
    // Idea: Array Copy or Three-Way Reverse Method
    //1234567 k=2   => 67 12345
    //[0 1 .... k-1] [k k+1 .... len-1]

    // Array Copy: extra O(n) memory
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;

        int [] t = Arrays.copyOfRange(nums, len-k, len);
        System.arraycopy(nums, 0, nums, k, len-k);
        System.arraycopy(t, 0, nums, 0, k);
    }

    // Three-Way Reverse Method: No extra memory needed
    public void rotateWithoutExtraSpace(int[] nums, int k) {
        int len = nums.length;
        k = k%len;

        rotateArray(nums,0,len-1);
        rotateArray(nums,0,k-1);
        rotateArray(nums,k,len-1);
    }

    private void rotateArray(int[] nums, int begin, int end){
        int i=begin; int j=end;
        if(j <= i){	return;}

        while(i<(end+begin+1)/2){
            int t = nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;	j--;
        }
    }
}
