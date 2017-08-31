//287. Find the Duplicate Number
//268 136

package collectionACompanies.microsoft;

public class Solution287 {

	public Solution287() {
		// TODO Auto-generated constructor stub
	}
	
	
    public int findDuplicate(int[] nums) {

    	//In-place o(n) solution
    	int len = nums.length;
    	if(len <2){	return -1;}
    	int res = -1;
    	
    	for(int i=0;i<len;i++){
    		// len = n+1
    		// Value is in [1,n]
    		// 0,1,2,...,n
    		int index = Math.abs(nums[i]);
    		if(nums[index] < 0){
    			res = index;
    			break;
    		}else{
    			nums[index] *= -1;
    		}    		
    	}
    	
    	for(int i=0;i<len;i++){
    		nums[i] = Math.abs(nums[i]);
    	}
    	
    	return res;
    	
    }
}
