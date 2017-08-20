//154. Find Minimum in Rotated Sorted Array II
//Duplicates are allowed
//209 106 048
package companies.microsoft;

public class Solution154 {

	public Solution154() {
		// TODO Auto-generated constructor stub
	}
	
    public int findMin(int[] nums) {
        
    	if(nums.length == 1){	return nums[0];}
    	
    	int len = nums.length;
    	int res = nums[0];
    	   	
    	res = rSearch(nums,0,len-1);    	    	
    	return res;
    	
    }	
	private int rSearch(int[] nums, int left, int right){
		
		if(nums[left] < nums[right]){
			return nums[left];
		}
		//L>=R
		int ni = left + (right - left)/2 ;
		if(ni == left){
			//array size <=2
			return Math.min(nums[left], nums[right]);						
		}else{
			
			if(nums[ni] == nums[left] && nums[ni] == nums[right]){
				//L=R o(n)
				return Math.min(rSearch(nums,left,ni), rSearch(nums,ni,right));
			}
			//L>R
    		else if(nums[ni] == nums[left]){	return rSearch(nums,ni,right);}
    		else if(nums[ni] == nums[right]){	return rSearch(nums,left,ni);}			
    		else{
    			//Now M != L/ R
				if(nums[ni] > nums[left]){
					return rSearch(nums,ni,right);
				}else if(nums[ni] < nums[right]){
					return rSearch(nums,left,ni);
				}else{
					return -1;
				}
    		}
		}
		
	}
}
