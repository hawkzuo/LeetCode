//167. Two Sum II - Input array is sorted
package threesums;

public class Solution167 {

	public Solution167() {
		// TODO Auto-generated constructor stub
	}
    public int[] twoSum(int[] nums, int target) {

    	//Since it's sorted. Two pointers can be used
    	//Runs in O(n) time
    	int [] res=new int[2];
    	int len=nums.length;
    	int i=0; int j=len-1;
    		while(i<j){
    			if(nums[i]+nums[j] < target){
    				i++;
    			}else if(nums[i]+nums[j] > target){
    				j--;
    			
    			}else{
    				res[0]=i+1;
    				res[1]=j+1;
    				return res;
    			}   			   			   			
    		}
        	return res;   		    	    		
    }
}
