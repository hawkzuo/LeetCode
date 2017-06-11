//15. 3Sum
package threesums;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution015 {

	public Solution015() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> threeSum(int[] nums) {

    	int target = 0;
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	if(nums.length < 3){	return res;}
    	if(nums.length == 3){ 
    		if( nums[0]+nums[1]+nums[2] == target){
    			List<Integer> l= new LinkedList<Integer>();
    			l.add(nums[0]);l.add(nums[1]);l.add(nums[2]);
    			res.add(l);
    			return res;
    		}else{
    			return res;
    		}    		
    	}

    	Arrays.sort(nums);     	
    	//Begin with the greatest    	
    	for(int k=nums.length-1;k>=2;k--){
    		if(k != nums.length-1 && nums[k] == nums[k+1]){
    			continue;
    		}
    		if(nums[k] < 0){
    			break;
    		}
    		
    		int sum = target - nums[k];
    		
    		int i=0; int j = k-1;
    		
    		while(i<j){
    			
    			if(nums[i] + nums[j] > sum){
//    				while(i<j && nums[j-1] == nums[j]){ j--;    }
    				j--;
    			}else if(nums[i] + nums[j] == sum){
        			List<Integer> l= new LinkedList<Integer>();
        			l.add(nums[i]);l.add(nums[j]);l.add(nums[k]);
        			res.add(l);    				
        			while(i<j && nums[j-1] == nums[j]){ j--;    }
        			while(i<j && nums[i+1] == nums[i]){ i++;	}    				
    				j--;i++;
    			}else{
//    				while(i<j && nums[i+1] == nums[i]){ i++;	}
    				i++;
    			}
    		}   		    		    		
    	}    	
    	
    	return res;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
