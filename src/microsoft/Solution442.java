//442. Find All Duplicates in an Array
package microsoft;

import java.util.LinkedList;
import java.util.List;

public class Solution442 {

	public Solution442() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> findDuplicates(int[] nums) {   	
    	List<Integer> res = new LinkedList<Integer>();

    	//len is used frequent. better save as a new local variable
    	int len = nums.length;
    	for(int i=0; i<len; i++){
    		int index;
    		
    		//Index pre-processing
    		if(nums[i] > len){
    			index = nums[i] - len -1;    	    			
    		}else{
    			index = nums[i]-1;   			
    		}
    		
    		//Hash to bucket
    		if(nums[index] > len){
    			res.add(index+1);
    		}else{
    			nums[index] += len;
    		}
 		
    	}
    	
    	return res;
    	    	
    }
    
    
    
    
}
