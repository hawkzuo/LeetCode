//260. Single Number III
//320 405 190
package bitmanipulate;

public class Solution260 {

	public Solution260() {
		// TODO Auto-generated constructor stub
	}

	
	public int[] singleNumber(int[] nums) {
        
		int len = nums.length;
		int mn = 0;
		
		for(int i=0;i<len;i++){
			
			mn ^= nums[i];
			
		}
		
		int lowest = mn & (~(mn-1));
		
		int [] res = new int[2];
		
		for(int i=0;i<len;i++){
			
			if((lowest & nums[i]) == 0){
				
				res[0] ^= nums[i];
			}else{
				
				res[1] ^= nums[i];
			}			
		}		
		return res;
		
    }
}
