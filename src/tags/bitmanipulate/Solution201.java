//201. Bitwise AND of Numbers Range

package tags.bitmanipulate;

public class Solution201 {

	public Solution201() {
		// TODO Auto-generated constructor stub
	}

    public int rangeBitwiseAnd(int m, int n) {
//9ms        
    	if(m == n){	return m;	}
    	//Bit Operations are far more quicker than divide '/'
//    	else if(m/n >=2){	return 0;}   
    	int res = 0;    	
    	for(int j=31;j>0;j--){
    		//Must add ()
    		//int sum = (m >> j) & 1 + (n >> j) & 1; is wrong
    		int sum = ((m >> j) & 1) + ((n >> j) & 1);
    		if(sum == 0){	continue;}
    		else if(sum == 2){	res += (1 << j);}
    		else{	break;}    		
    	}
    	return res;    	
    }
    //3.2%
    public int rangeBitwiseAnd2(int m, int n) {
        
    	if(m == n){	return m;	}
    	else if(m/n >=2){	return 0;}
    	
    	int[] ms = new int[32];
    	int[] ns = new int[32];
    	
    	for(int i=0;i<32;i++){
    		
    		ms[i] = (m >> i) & 1;
    		
    		ns[i] = (n >> i) & 1;
    	}
    	
    	int res = 0;
    	for(int j=31;j>0;j--){
    		if(ms[j] == 0 && ns[j] == 0){
    			;    			   			
    		}else if(ms[j] == 1 && ns[j] == 1){
    			res += ( 1 << j);
    		}else{
    			break;
    		}    		
    	}
    	return res;
    	
    }
    public int rangeBitwiseAnd3(int m, int n) {
        int r=Integer.MAX_VALUE;
        while((m&r)!=(n&r))  r=r<<1;
        return n&r;
    }
    public static void main(String[] args) {
    	
    	Solution201 s = new Solution201();

    	int res = s.rangeBitwiseAnd(5, 7);

    	System.out.print(res);

    } 	
}
