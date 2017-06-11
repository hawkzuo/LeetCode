//461. Hamming Distance

package bitmanipulate;

public class Solution461 {

	public Solution461() {
		// TODO Auto-generated constructor stub
	}
	
    public int hammingDistance(int x, int y) {            	
    	int res = x^y;    	
    	int count = 0;    	
    	while(res != 0){
    		res &= res-1;
    		count ++;
    		    		
    	}    	
    	return count;
    	
    }
    
//477  time limit exceed Omega(n^2)  
    public int totalHammingDistance2(int[] nums) {
        int res=0;
    	if(nums.length == 1){	return res;}
    	for(int i=0;i<nums.length-1;i++){
    		for(int j=1+i;j<nums.length;j++){
    			res += hammingDistance(nums[i],nums[j]);
    		}
    		
    	}
    	return res;    	
    }    

    
	public static void main(String[] args) {
		

		Solution461 s=new Solution461();
		int [] k = {4,14,4,14};
		int res = s.totalHammingDistance2(k);
		System.out.print(res);
		
	}     
    
    
}
