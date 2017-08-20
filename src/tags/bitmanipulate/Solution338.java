//338. Counting Bits

package tags.bitmanipulate;

public class Solution338 {

	public Solution338() {
		// TODO Auto-generated constructor stub
	}
	
	
    public int[] countBits(int num) {
//DP ??
    	//New value has connection with old values      => DP 
    	int[] res = new int[num+1];
    	int hold = 1;
    	int base = 0;
    	
    	for(int i=0;i<=num;i++){
    		if(i == 0){	res[i] = 0;}
    		else if(i == 1){ res[i] = 1;}
    		else{
    			if(i == (hold << 1)){
    				base = 1;
    				res[i] = 1;
    				hold = hold << 1;
    			}else{
    				res[i] = base + res[i-hold];
    			}
    		}
    	}
    	return res;
    	
    }
    public static void main(String[] args) {
    	
    	Solution338 s = new Solution338();

    	int[] res = s.countBits(16);
    	for(int i=0;i<res.length;i++){
    	System.out.print(res[i]+" ");
    	}
    }    
}
