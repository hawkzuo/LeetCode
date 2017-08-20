//268. Missing Number

package companies.microsoft;

public class Solution268 {

	public Solution268() {
		// TODO Auto-generated constructor stub
	}
//Can use bit-manipulation Still O(n)
//They use the xor calculation
	public int missingNumber2(int[] nums) {

	    int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}
//Mine use +2n calculation	
    public int missingNumber(int[] nums) {
        //0 1 3 => 2
    	// 0 1 2 =3
    	// 123 =0
    	int len = nums.length;
    	if(len <1){	return -1;}    	
    	
    	for(int i=0;i<len;i++){
    		//*-1 is not quite good
    		int index;
    		if(nums[i] <= len){
    			index = nums[i]; 
    		}else{
    			index = nums[i] - 2*len;
    			
    		}
    		if(index == len){
    			continue;
    		}
    		
    		if(nums[index] <= len){
    			nums[index] += 2*len;
    		}else{
    			return -1;
    		}    		
    	}
    	
    	int res=-1;
    	for(int i=0;i<len;i++){
    		if(nums[i] > len){
    			continue;
    		}else{
    			res = i;
    			break;
    		}
    	}
    	for(int i=0;i<len;i++){
    		if(nums[i] > len){
    			nums[i] -= 2*len;
    		}
    	}
    	if(res != -1){	return res;}
    	return len;    	
    	
    }
}
