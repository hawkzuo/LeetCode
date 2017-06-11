//16. 3Sum Closest
package threesums;

import java.util.Arrays;

public class Solution016 {

	public Solution016() {
		// TODO Auto-generated constructor stub
	}
    public int threeSumClosest(int[] nums, int target) {
    	if(nums.length < 3){	return -1;}
    	if(nums.length == 3){ return nums[0]+nums[1]+nums[2];}

    	Arrays.sort(nums);         
//Hard to understand unique solution    	
    	int k;
    	int lowest=Integer.MIN_VALUE;
    	int highest=Integer.MAX_VALUE;
   	
    		if(nums[nums.length-1]-target < target - nums[0]){
    			for(k=nums.length-1;k>=2;k--){    				
    				int i=0; int j=k-1;
    				
    				while(i<j){
    					int cur = nums[i] + nums[j] + nums[k];
    					if( cur > target){
    						highest = Math.min(highest,cur);
    						j--;
    						
    					}else if(cur < target){
    						lowest = Math.max(lowest, cur);
    						i++;
    					}else{
    						return target;
    					}   					
    				}   				
    			}
    			
    		}else{
    			for(k=0;k<=nums.length-3;k++){
    				int i=k+1; int j=nums.length-1;
    				
    				while(i<j){
    					int cur = nums[i] + nums[j] + nums[k];
    					if( cur > target){
    						highest = Math.min(highest,cur);
    						j--;
    						
    					}else if(cur < target){
    						lowest = Math.max(lowest, cur);
    						i++;
    					}else{
    						return target;
    					}   					
    				}     				
    			}
    		}
    		return (highest + lowest - 2* target) > 0 ? lowest : highest;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1	};
		Solution016 s = new Solution016();
		System.out.println(s.threeSumClosest(arr, 0));
		
	}

}
