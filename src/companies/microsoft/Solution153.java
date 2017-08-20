//153. Find Minimum in Rotated Sorted Array

package companies.microsoft;

public class Solution153 {

	public Solution153() {
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
		
		int ni = left + (right - left)/2 ;
		if(ni == left){
			return Math.min(nums[left], nums[right]);						
		}else{
			
			if(nums[ni] > nums[left]){
				return rSearch(nums,ni,right);
			}else if(nums[ni] < nums[right]){
				return rSearch(nums,left,ni);
			}else{
				return -1;
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution153 s = new Solution153();
		int[] t = {1,1};
		int res = s.findMin(t);
		System.out.print(res);
	} 	
}
