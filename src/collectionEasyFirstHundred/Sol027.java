package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Remove Element
 */
public class Sol027 {
    // Idea: Brute-force Matching, same as Sol026
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){ return 0;}
        if(nums.length == 1){
            return nums[0] == val ? 0:1 ;
        }
        //len now >=2
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            while(fast < nums.length && nums[fast] == val){
                fast++;
            }
            if(fast < nums.length){
                nums[slow++] = nums[fast++];
            }else{
                break;
            }
        }
        return slow;
    }
}
