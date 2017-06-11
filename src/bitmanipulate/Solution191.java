//191. Number of 1 Bits

//Challenge 401 338 190
package bitmanipulate;

public class Solution191 {

	public Solution191() {
		// TODO Auto-generated constructor stub
	}

	
	public int hammingWeight2(int n) {
    	int count = 0;    	
    	while(n != 0){
    		n &= n-1;
    		count ++;
    		    		
    	}    	
    	return count;        
    }
	public int hammingWeight(int n) {
		int count = 0;
		for(int j=0;j<32;j++){    			
			//Unsigned int 32-bits
				count += (n >>> j) & 1;			
		}   
		return count;
    }
		
	
	
}
