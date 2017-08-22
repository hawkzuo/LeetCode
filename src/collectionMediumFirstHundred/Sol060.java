package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/23.
 * Permutation Sequence
 */
public class Sol060 {
    int [] ref = {1,1,2,6,24,120,720,5040,40320,362880};

    public String getPermutation(int n, int k) {
        if(n == 1){
            return "1";
        }else if(n==2){
            if(k==1){
                return "12";
            }else{
                return "21";
            }
        }
        List<Integer> input = new ArrayList<Integer>();
        k -= 1;
        for(int i=1;i<=n;i++){
            input.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(n >= 3){
            // Generate the result bit by bit
            // Reason: Math properties
            int cur = k / ref[n-1];
            k = k % ref[n-1];
            sb.append(Integer.toString(input.get(cur)));
            input.remove(cur);
            n--;
        }
        // Final 2 bits
        if(k == 0){
            sb.append(Integer.toString(input.get(0)));
            sb.append(Integer.toString(input.get(1)));
        }else{
            sb.append(Integer.toString(input.get(1)));
            sb.append(Integer.toString(input.get(0)));
        }
        return sb.toString();
    }
}
