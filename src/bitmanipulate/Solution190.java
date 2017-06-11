//190. Reverse Bits


package bitmanipulate;

public class Solution190 {

	public Solution190() {
		// TODO Auto-generated constructor stub
	}
    public int reverseBits(int n) {
		int res = 0;
		
		for(int j=0;j<32;j++){      			
			//Unsigned int 32-bits
			    res <<= 1;
				res += (n >>> j) & 1;			
		}   

		return res;        
    }
    public static void main(String[] args) {
    	
    	Solution190 s = new Solution190();
    	
    	int res = s.reverseBits(43261596);
    	System.out.print(res == 964176192);
    }
    
}
