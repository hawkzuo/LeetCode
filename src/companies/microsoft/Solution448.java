//448. Find All Numbers Disappeared in an Array
package companies.microsoft;

import java.util.LinkedList;
import java.util.List;

public class Solution448 {

	public Solution448() {
		// TODO Auto-generated constructor stub
	}
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }
        
        for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                result.add(j);
            }
        }
        return result;        
    }	
	
	
    public List<Integer> findDisappearedNumbers2(int[] nums) {
    	List<Integer> res = new LinkedList<Integer>();

    	//len is used frequent. better save as a new local variable
    	int len = nums.length;
    	for(int i=0; i<len; i++){
    		int index;
    		
    		if(nums[i] > len){
    			index = nums[i] - len -1;    	    			
    		}else{
    			index = nums[i]-1;   			
    		}

    		if(nums[index] > len){
    			;
    		}else{
    			nums[index] += len;
    		}
    	}
    	for(int j=0;j<len;j++){
    	    if(nums[j] <= len){
    	        res.add(j+1);
    	    }
    	    
    	}   	
    	return res;        
    }
}
