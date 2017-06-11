//371. Sum of Two Integers

package bitmanipulate;

public class Solution371 {

	public Solution371() {
		// TODO Auto-generated constructor stub
	}
    public int getSum(int a, int b) {
        int c = 0;
        int res =0;
    	for(int i=0;i<32;i++){
    		int an = (a >> i) & 1;
    		int bn = (b >> i) & 1;   		
    		res ^= ((~an&~bn&c)|(~an&bn&~c)|(an&~bn&~c)|(an&bn&c)) << i;
    		c = (an&bn&c)|(an&bn&~c)|(an&~bn&c)|(~an&bn&c);
    		
    	}
    	return res;   	
    	
    }
    public static void main(String[] args) {
    	
    	Solution371 s = new Solution371();

    	int res = s.getSum(2, 3);

    	System.out.print(res);

    }     
}
