//477. Total Hamming Distance

//Challenge 187 338 401
package tags.bitmanipulate;

public class Solution477 {

	public Solution477() {
		// TODO Auto-generated constructor stub
	}

//25	
    public int totalHammingDistance3(int[] nums) {
        int res=0;
    	if(nums.length == 1){	return res;}
    	
    	int len = nums.length;
    	int [] ones = new int[31];
    	//Space for time
    	for(int i=0;i<len;i++){
    		for(int j=0;j<31;j++){    			
    			//Use if else
    				ones[j] += (nums[i] >> j) & 1;
    			
    			
    		}   		
    	}
    	for(int j=0;j<31;j++){
    		res += ones[j] * (len-ones[j]);
    	}
    	
    	return res;    	
    } 
//68
    public int totalHammingDistance2(int[] nums) {
        int res=0;
    	if(nums.length == 1){	return res;}
    	
    	int len = nums.length;
    	int [] ones = new int[31];
    	//Space for time
    	for(int i=0;i<len;i++){
    		for(int j=0;j<31;j++){    			
                ones[j] += (nums[i] >> j) & 1;
    			
    		}   		
    	}
    	for(int j=0;j<31;j++){
    		res += ones[j] * (len-ones[j]);
    	}
    	
    	return res;    	
    }     
//87    
    public int totalHammingDistance(int[] nums) {
        int res=0;
    	if(nums.length == 1){	return res;}
    	
    	int len = nums.length;
    	int [] ones = new int[31];
    	//Space for time
		for(int j=0;j<31;j++){
			for(int i=0;i<len;i++){			
                ones[j] += (nums[i] >> j) & 1;   			
    		}
			res += ones[j] * (len-ones[j]);
    	}
    	    	return res;    	
    }     
    
    
    
}
