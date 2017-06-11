//259. 3Sum Smaller
package threesums;

import java.util.Arrays;

public class Solution259 {

	public Solution259() {
		// TODO Auto-generated constructor stub
	}
    public int threeSumSmaller(int[] nums, int target) {

    	if(nums.length < 3){	return 0;}
    	if(nums.length == 3){ return nums[0]+nums[1]+nums[2] < target ? 1:0;}

    	Arrays.sort(nums);    	
    	int total = 0;   	
    	//Begin with the greatest    	
    	for(int k=nums.length-1;k>=2;k--){
    		int sum = target - nums[k];
    		
    		int i=0; int j = k-1;
    		
    		while(i<j){
    			
    			while(i<j && nums[i] + nums[j] >= sum){
    				j--;    				    				
    			}
    			if(j<=i ){	break;}
    			
    			//j only move to one position
    			total+= j-i;
    			i++;    			
    			
    		}   		    		
    		
    	}
    	return total;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution259 s = new Solution259();
		int [] n1 = {1,1,1,1,2,2,2,2,3,3,3,3};
		System.out.print(s.threeSumSmaller(n1, 12));
	}

}
