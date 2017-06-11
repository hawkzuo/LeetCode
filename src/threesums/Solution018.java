//18. 4Sum
package threesums;
import java.util.*;
public class Solution018 {

	public Solution018() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums.length < 4){	return res;}
    	if(nums.length == 4){ 
    		if( nums[0]+nums[1]+nums[2]+nums[3] == target){
    			List<Integer> l= new LinkedList<Integer>();
    			l.add(nums[0]);l.add(nums[1]);l.add(nums[2]);l.add(nums[3]);
    			res.add(l);
    			return res;
    		}else{
    			return res;
    		}    		
    	}        
        Arrays.sort(nums);     	
    	//Begin with the greatest  
    	
    	
    	for(int outL=0;outL<nums.length-3;outL++){
    	    //This one must be added to eliminate duplicates on Rleft.
    	    if(outL !=0 && nums[outL] == nums[outL-1]){
    	        continue;
    	    }
    	    
    	    int outR=nums.length-1;
        	while(outL+2 < outR){
        	    
        	    int ntar = target - nums[outL] - nums[outR];
        	    int i=outL+1;   int j=outR-1;
        	    while(i<j){
        			if(nums[i] + nums[j] > ntar){
        				while(i<j && nums[j-1] == nums[j]){ j--;    }
        				j--;
        			}else if(nums[i] + nums[j] == ntar){
            			List<Integer> l= new LinkedList<Integer>();
            			l.add(nums[outL]);l.add(nums[i]);l.add(nums[j]);l.add(nums[outR]);
            			res.add(l);    				
            			while(i<j && nums[j-1] == nums[j]){ j--;    }
            			while(i<j && nums[i+1] == nums[i]){ i++;	}    				
        				j--;i++;
        			}else{
        				while(i<j && nums[i+1] == nums[i]){ i++;	}
        				i++;
        			}    	        
        	    }
        	    //This one must be added too, to eliminate duplicates on Rout.
        	    while(outL+2<outR && nums[outR-1] == nums[outR]){ outR--;}
        	    outR--;
        	}    	    
    	}
    	return (res);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
