//1. Two Sum
package threesums;

import java.util.HashMap;

public class Solution001 {

	public Solution001() {
		// TODO Auto-generated constructor stub
	}
    public int[] twoSum(int[] nums, int target) {
    	//key is number in array, value is index
    	
    	//HashMap O(n) solution
        int[] res =new int[2];
        
        HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }
            else{
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                break;
            }
        }
        return res;
    	
    }
    public int[] twoSum2(int[] nums, int target) {
    	
    	//Sort O(nlogn) solution --not applicable
    	// O(n^2) solution: 2 loops
    	int [] res =new int[2];
    	for(int i=0;i<nums.length;i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(nums[i]+nums[j]==target){
    				res[0]=i;res[1]=j;
    				return res;
    			}  			   			
    		}    		
    	}
    	res[0]=0;res[1]=0;
    	return res;
    }    
    
    
}
