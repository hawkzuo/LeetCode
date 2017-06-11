//397. Integer Replacement

package bitmanipulate;

public class Solution397 {

	public Solution397() {
		// TODO Auto-generated constructor stub
	}
    public int integerReplacement(int n) {
    	//Since only one value is needed, no need to do it with DP
    	//If output is an array of all possible answers <=n can use DP
        long N = n;
        long small,big;
        int cnt = 0;
        while( N != 1){
        	small = (N  & ( N -1));
        	big = ( N & (N + 1));
        	if( (N & 1) == 0){
        		N >>= 1;
        	}
        	else if ( (small & (small-1)) <= (big & (big-1))){
        		N = N - 1;
        	}
        	else{
        		N = N +1;
        	}
        	cnt++;
        }
        return cnt;
    }
    public int integerReplacement2(int n) {
    	//Since only one value is needed, no need to do it with DP
    	//If output is an array of all possible answers <=n can use DP
        long N = n;
        int cnt = 0;
        while( N != 1){
        	long pivot = (N+1) & 3;
        	if( (N & 1) == 0){
        		N >>= 1;
        	}
        	//pivot == 0 guarantees the ability to be divided by 4 
        	else if (pivot != 0 || N==3){
        		N = N - 1;
        	}
        	else{
        		N = N +1;
        	}
        	cnt++;
        }
        return cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution397 s = new Solution397();
		System.out.println(s.integerReplacement(194754239));
		System.out.println(s.integerReplacement2(194754239));
	}

}
