package collectionMedium;

/**
 * Created by Amos on 2017/7/26.
 * Remove Duplicates from Sorted Array II
 */
public class Sol080 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}
        else if(nums.length <= 2){  return nums.length;}

        int saved = nums[0];    int duplicateCount = 1;
        int pSlow = 1;  int cur = 1;
        while(cur < nums.length){
            if(nums[cur] == saved){
                // If duplicates != 2, we add saved number to result array,
                // otherwise, skip this value
                if (duplicateCount != 2) {
                    duplicateCount = 2;
                    nums[pSlow++] = saved;
                }
            }else{
                // Update saved value and append to result array
                saved = nums[cur];    duplicateCount = 1;
                nums[pSlow++] = saved;
            }
            cur++;
        }
        return pSlow;
    }
}
