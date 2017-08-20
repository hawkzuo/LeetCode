//53. Maximum Subarray

package tags.dynamicprogramming;

public class Solution053 {

    public int maxSubArray(int[] nums) {
        
        int len = nums.length;
        if(len == 0){   return 0;}
        
        
        int [] maxend = new int[len];
        maxend[0] = nums[0];
        int max = maxend[0];
        for(int j=1;j<len;j++){
            
            if(maxend[j-1]>0){
                maxend[j] = maxend[j-1] + nums[j];
            }else{
                maxend[j] = nums[j];
            }
            
            max = Math.max(max,maxend[j]);
            
        }
        return max;
    }

}
