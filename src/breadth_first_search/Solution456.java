package breadth_first_search;

public class Solution456 {

	public Solution456() {
		// TODO Auto-generated constructor stub
	}
    public boolean find132pattern(int[] nums) {
        
    	int l = 0; int m=-1;
    	if(nums.length < 3){	return false;}
    	
    	
    	for(int i = 1;i<nums.length;i++){
    		
    		if(m < 0){
    			if(nums[i] > nums[l]){
    				m=i;
    			}else{
    				l=i;
    			}
    			
    			
    		}else{
    			if(nums[i] < nums[m] && nums[i] > nums[l]){
    				return true;
    			}else if(nums[i] < nums[m] && nums[i] <= nums[l]){
    				l=i;
    				m=-1;
    			}else if(nums[i] == nums[m]){
    				l=i;
    				m=-1;
    			}else{
    				l=m;
    				m=i;
    			}
    			
    		}    		
    	}
    	
    	return false;
    	
   	
    }
    public static void main(String[] args) {
    	
    	Solution456 s = new Solution456();
    	int [] a = {255,254,253,254,253,255,254};
    	System.out.print(s.find132pattern(a));
    	
    	
    	
    }
}
