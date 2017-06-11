//81. Search in Rotated Sorted Array II
//Duplicates are allowed
//289 238 40
package microsoft;

public class Solution081 {

	public Solution081() {
		// TODO Auto-generated constructor stub
	}
    public boolean search(int[] nums, int target) {
    	if(nums.length == 1){	return nums[0] == target ? true:false;}    	
    	int len = nums.length;
    	boolean res = false;    		
    	res = rSearch(nums,0,len-1,target);
    	return res;        
    }
    
    private boolean bSearch(int[] nums, int left, int right, int tar){
    	//1234567
    	//A[l] <(=)? A[r]    	
    	if(tar < nums[left] || tar > nums[right]){
    		return false;
    	}
    	int ni = left + (right - left)/2 ;    	
    	if(ni == left){
    		if(nums[left] == tar){
    			return true;
    		}
    		if(nums[right] == tar){
    			return true;
    		}
    		return false;
    	}else{
    		if(nums[ni] == tar){	return true;}
    		else if(nums[ni] > tar){	return bSearch(nums,left,ni,tar);}
    		else{	return bSearch(nums,ni,right,tar);}    		    		
    	}
    	
    	
    	
    }
    private boolean rSearch(int[] nums, int left, int right, int tar){
    	//A[l] >= A[r] is guaranteed
    	if(tar < nums[left] && tar > nums[right]){
    		return false;
    	}
		if(nums[left] == tar){
			return true;
		}
		if(nums[right] == tar){
			return true;
		}		
		
    	int ni = left + (right - left)/2 ;
    	if(ni == left){
    		return false;
    	}else{    	
    		if(nums[ni] == tar){	return true;}
    		else if(nums[ni] == nums[left] && nums[ni] == nums[right]){	
    		    //worst case o(n)
    		    return rSearch(nums,ni,right,tar) || rSearch(nums,left,ni,tar);
    		    
    		}
    		else if(nums[ni] == nums[left]){	return rSearch(nums,ni,right,tar);}
    		else if(nums[ni] == nums[right]){	return rSearch(nums,left,ni,tar);}
    		else{
    			//Now M != L/ R
    			
    			if(nums[ni] > nums[left]){
    				if(tar < nums[ni] && tar > nums[left]){
    					return bSearch(nums,left,ni,tar);
    				}else{
    					return rSearch(nums,ni,right,tar);
    				}
    				
    			}else if(nums[ni] < nums[right]){
    				if(tar > nums[ni] && tar < nums[right]){
    					return bSearch(nums,ni,right,tar);
    					
    				}else{
    					return rSearch(nums,left,ni,tar);
    				}
    				
    			}else{
    				return false;
    			}
    			
    			
    		}
    	}
    }
    //Violence solution
    public boolean search2(int[] nums, int target) {
    	if(nums.length == 1){	return nums[0] == target ? true:false;}
    	
    	int len = nums.length;
    	
    		
    	for(int i=0;i<len;i++){
    	    if(nums[i] == target){
    	        return true;
    	    }
    	}

    	return false;        
    }
    
    
    
}
