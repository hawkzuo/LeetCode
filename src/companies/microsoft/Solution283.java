//283. Move Zeroes
package companies.microsoft;

public class Solution283 {

	public Solution283() {
		// TODO Auto-generated constructor stub
	}
    public void moveZeroes(int[] nums) {
    	if(nums.length <= 1){ return; }
    	//target = 0;
    	int slow = 0;
    	int fast = 0;    	    	
    	while(fast < nums.length){    		
    		while(fast < nums.length && nums[fast] == 0){    			
    			fast++;   			
    		}
    		if(fast < nums.length){    			
    			nums[slow++] = nums[fast++];
    		}   		
    	}   	
    	
    	while(slow < nums.length){
    		
    		nums[slow++] = 0;
    		
    	}
    	
    }
}
