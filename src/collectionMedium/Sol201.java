package collectionMedium;

/**
 * Created by Amos on 2017/8/21.
 * Bitwise AND of Numbers Range
 */
public class Sol201 {
    public int rangeBitwiseAnd(int m, int n) {
        // Idea: Matching m&n bit by bit, starting with highest bit
        //      Once encounter case other than '00' or '11', stop and return value
        //      Reason: if at k bit exists '0' '1' combination, then lower bits must have '0' '1' combinations
        //              during the intervals

        if(m == n){	return m;	}
//Bit Operations are far more quicker than divide '/'
//    	else if(m/n >=2){	return 0;}
        int res = 0;
        for(int j=31;j>=0;j--){
            int sum = ((m >> j) & 1) + ((n >> j) & 1);
            if (sum != 0) {
                if(sum == 2){	res += (1 << j);}
                else{	break;}
            }
        }
        return res;
    }
}
