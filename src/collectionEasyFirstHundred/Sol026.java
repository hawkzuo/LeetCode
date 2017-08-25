package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Remove Duplicates from Sorted Array
 */
public class Sol026 {
    // Idea: Brute-force Matching
    public int removeDuplicates(int[] nums) {

        if(nums.length <= 1){return nums.length;}
        int slow = 1;
        int fast = 1;
        int value = nums[0];

        while(fast < nums.length){
            while(fast < nums.length && nums[fast] == value){
                fast ++;
            }
            if(fast < nums.length){
                value = nums[fast++];
                nums[slow++] = value;
            }
        }
        return slow;
    }
}
