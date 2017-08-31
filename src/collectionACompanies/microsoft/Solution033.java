//33. Search in Rotated Sorted Array
//153 81 154
package collectionACompanies.microsoft;

public class Solution033 {

	public Solution033() {
		// TODO Auto-generated constructor stub
	}
    public int search(int[] nums, int target) {
        
    	if(nums.length == 1){	return nums[0] == target ? 0:-1;}
    	
    	int len = nums.length;
    	int res = -1;
    	if(nums[0] < nums[len-1]){
    		res = bSearch(nums,0,len-1,target);
    		
    	}else{
    		
    		res = rSearch(nums,0,len-1,target);
    		
    		
    		
    	}
    	
    	return res;
    	
    	
    	
    	
    	
    }
    private int bSearch(int[] nums, int left, int right, int tar){
    	//1234567
    	//A[l] < A[r]    	
    	if(tar < nums[left] || tar > nums[right]){
    		return -1;
    	}
    	int ni = left + (right - left)/2 ;
    	
    	if(ni == left){
    		if(nums[left] == tar){
    			return left;
    		}
    		if(nums[right] == tar){
    			return right;
    		}
    		return -1;
    	}else{
    		if(nums[ni] == tar){	return ni;}
    		else if(nums[ni] > tar){	return bSearch(nums,left,ni,tar);}
    		else{	return bSearch(nums,ni,right,tar);}    		    		
    	}
    	
    	
    	
    }
    private int rSearch(int[] nums, int left, int right, int tar){
    	//A[l] > A[r]
    	if(tar < nums[left] && tar > nums[right]){
    		return -1;
    	}
		if(nums[left] == tar){
			return left;
		}
		if(nums[right] == tar){
			return right;
		}
		
    	int ni = left + (right - left)/2 ;
    	if(ni == left){
    		return -1;
    	}else{    	
    		if(nums[ni] == tar){	return ni;}
    		else{
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
    				return -1;
    			}
    			
    			
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution033 s = new Solution033();
		int[] t = {4,5,6,7,8,9,0,1,2};
		int res = s.search(t, 12);
		System.out.print(res);
	}    
    
}
