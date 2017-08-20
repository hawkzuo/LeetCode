//189. Rotate Array
package companies.microsoft;

import java.util.Arrays;

public class Solution189 {

	public Solution189() {
		// TODO Auto-generated constructor stub
	}
	
	
	
//Extra O(n) space needed	
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k%len;  	
        //1234567 k=2   => 67 12345                
    	//[0 1 .... k-1] [k k+1 .... len-1]    	
        //Source,BeginIndex(include),EndIndex(not include)
        
    	int [] t = Arrays.copyOfRange(nums, 0, len-k);
    	
    	
    	//Source,BeginIndex,Destination,EndIndex,LengthofCopy (include)
    	System.arraycopy(nums, len-k, nums, 0, k);    	
    	System.arraycopy(t, 0, nums, k, len-k);

    	
    }
    public void rotate3(int[] nums, int k) {

        int len = nums.length;
        k = k%len;  	
        //1234567 k=2   => 67 12345                
    	//[0 1 .... k-1] [k k+1 .... len-1]    	
        //Source,BeginIndex(include),EndIndex(not include)
        
    	int [] t = Arrays.copyOfRange(nums, len-k, len);
    	   	
    	//Source,BeginIndex,Destination,EndIndex,LengthofCopy (include)
    	System.arraycopy(nums, 0, nums, k, len-k);    	
    	System.arraycopy(t, 0, nums, 0, k);

    	
    }  
//No extra space needed.    
    public void rotate2(int[] nums, int k) {

        int len = nums.length;
        k = k%len;  	
        //1234567 k=2   => 67 12345                
    	//[0 1 .... k-1] [k k+1 .... len-1]    	
        //Source,BeginIndex(include),EndIndex(not include)
       
        rotateint(nums,0,len-1);
        rotateint(nums,0,k-1);
    	rotateint(nums,k,len-1);
    }    

    private void rotateint(int[] nums, int begin, int end){
    	
    	int i=begin; int j=end;
    	if(j <= i){	return;}
    	
    	while(i<(end+begin+1)/2){
    		int t = nums[i];
    		nums[i]=nums[j];
    		nums[j]=t;
    		i++;	j--;    		
    	}    	
    	
    }
    
    
    
	public static void main(String[] args) {
		Solution189 s = new Solution189();
		int [] arr = {1,2,3,4,5,6,7};
		s.rotate3(arr, 2);
		System.out.print(s);
	}   
    
    
    
    
    
}

