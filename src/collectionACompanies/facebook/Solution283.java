package collectionACompanies.facebook;

public class Solution283 {

	public Solution283() {
		// TODO Auto-generated constructor stub
	}
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1){
            return;
        }
        // vindex is faster
        int zindex = 0; int vindex = 0;
        while(vindex < nums.length){
            if(nums[vindex] == 0){
                vindex++;
            }else{
                while(zindex < vindex){
                    if(nums[zindex] != 0){
                        zindex++;
                    }else{
                        break;
                    }
                }
                if(zindex != vindex){                    
                    nums[zindex]=nums[vindex];
                    nums[vindex]=0;
                }
                vindex++;
            }
        }
    }
}
