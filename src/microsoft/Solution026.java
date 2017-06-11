//26. Remove Duplicates from Sorted Array
package microsoft;

public class Solution026 {

	public Solution026() {
		// TODO Auto-generated constructor stub
	}
    public int removeDuplicates(int[] nums) {
    	
    	if(nums.length <= 1){return nums.length;}
    	
    	int slow = 1;
    	int fast = 1;
    	
    	int value = nums[0];
    	
    	
    	while(fast < nums.length){
    		
    		while(fast < nums.length && nums[fast] == value){
    			fast ++;
    			
    		}
    		if(fast < nums.length){
    			value = nums[fast++];
    			nums[slow++]=value;   
    		}
    	}
    	
    	return slow;
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution026 s = new Solution026();
		int[] arr = {1,1};
		System.out.println(s.removeDuplicates(arr));
		
		
		
	}    
}
