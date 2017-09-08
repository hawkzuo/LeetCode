package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/7.
 */
public class Sol283 {
    // Idea: Two-pointers swapping
    //  Step-by-step moving chars
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }
        // valueIndex is faster
        // swapping instead of copying all zeroes between them
        int zeroIndex = 0; int valueIndex = 0;
        while(valueIndex < nums.length){
            if(nums[valueIndex] == 0){
                valueIndex++;
            }else{
                // Use 'lazy' update on zeroIndex, only update while it's been used, that is, there's a new value needed
                // to be copied to the front.
                while(zeroIndex < valueIndex){
                    if(nums[zeroIndex] != 0){
                        zeroIndex++;
                    }else{
                        break;
                    }
                }
                if(zeroIndex != valueIndex){
                    nums[zeroIndex]=nums[valueIndex];
                    nums[valueIndex]=0;
                }
                valueIndex++;
            }
        }
    }
}
