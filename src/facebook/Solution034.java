package facebook;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int lbound = -1;    int rbound = -1;
        int [] res = new int[2];
        res[0] = lbound;    res[1] = rbound;
        
        if(nums == null || nums.length == 0 || target > nums[nums.length-1] || target < nums[0]){
            return res;
        }
        
        int len = nums.length;
        
        int l = 0;  int r=len-1;
        while(l+1<r){
            int mid = l+(r-l)/2;
            
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(nums[l] == target){
            lbound = l;
        }else if(nums[r] == target){
            lbound = r;
        }else{
            return res;
        }
        
        
        l = 0; r = len-1;
        while(l+1<r){
            int mid = l+(r-l)/2;
            
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid;
            }            
            
        }
        if(nums[r] == target){
            rbound = r;
        }else if(nums[l] == target){
            rbound = l;
        }else{
            return res;
        }        
        
        res[0] = lbound;
        res[1] = rbound;
        return res;

    }
}