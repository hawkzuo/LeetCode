//454. 4Sum II
package threesums;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {

	public Solution454() {
		// TODO Auto-generated constructor stub
	}
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null|| C == null|| D == null){ return 0;}
        int target = 0; int N = A.length; int count=0;
        if(N == 0){ return 0;}
        Map<Integer,Integer> holder = new HashMap<Integer,Integer>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int cur = A[i]+B[j];
                if(holder.containsKey(cur)){
                    holder.put(cur,holder.get(cur)+1);
                }else{
                    holder.put(cur,1);
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int cur = target-C[i]-D[j];
                if(holder.containsKey(cur)){
                    count+=holder.get(cur);
                }else{
                   ;
                }
            }
        }        
        return count;
    }
}
