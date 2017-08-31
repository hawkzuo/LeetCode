package collectionACompanies.facebook;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2){   return false;}
        int gMin1 = nums[0];  int gMin2 = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= gMin1){
                gMin1 = nums[i];
            }else{
                if(nums[i] <= gMin2){	gMin2 = nums[i];	}
                else{	return true;	}
            }
        }
        return false;
    }

}
