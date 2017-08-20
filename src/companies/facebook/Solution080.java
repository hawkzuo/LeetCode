package companies.facebook;

public class Solution080 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}
        else if(nums.length <= 2){  return nums.length;}       
        int saved = nums[0];    int tmpCount = 1;   
        int pSlow = 1;  int cur = 1;
        while(cur < nums.length){
            if(nums[cur] == saved){
                if(tmpCount != 2){
                    tmpCount = 2;
                    nums[pSlow++] = saved;
                }
            }else{
                saved = nums[cur];    tmpCount = 1;
                nums[pSlow++] = saved;
            }
            cur++;
        }
        return pSlow;
    }

}
