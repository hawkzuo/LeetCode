//27. Remove Element
package microsoft;

public class Solution027 {

	public Solution027() {
		// TODO Auto-generated constructor stub
	}
    public int removeElement(int[] nums, int val) {
        
    	if(nums.length == 0){ return 0;}
    	if(nums.length == 1){    		   		
    		return nums[0] == val ? 0:1 ;
    	}    	
    	//len now >=2   	
    	int slow = 0;
    	int fast = 0;    	    	
    	while(fast < nums.length){    		
    		while(fast < nums.length && nums[fast] == val){    			
    			fast++;   			
    		}
    		if(fast < nums.length){    			
    			nums[slow++] = nums[fast++];
    		}   		
    	}   	
    	return slow;  	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution027 s = new Solution027();
		int[] arr = {1};
		System.out.println(s.removeElement(arr, 1));
		System.out.println("haha");
		
		
	}      
}
