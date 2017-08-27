package collectionEasyFirstHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/8/25.
 * Single Number
 */
public class Sol136 {
    // Idea: XOR all, get the single element    -> Bit Manipulation

    public int singleNumber(int[] A) {
        int result=A[0];
        for(int i=1;i<A.length;i++) {
            result = result^A[i];  /* Get the xor of all elements */
        }
        return result;
    }

    // Map Method
    public int singleNumberViaMap(int[] A) {
        Map<Integer,Integer> m = new HashMap<>();

        for (int num : A) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else {
                m.put(num, m.get(num) + 1);
            }
        }

        for( Map.Entry<Integer, Integer> entry : m.entrySet() ){
            int v = entry.getValue();
            if(v != 2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
