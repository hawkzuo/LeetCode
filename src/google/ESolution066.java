package google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amos on 2017/6/11.
 */
public class ESolution066 {
    public int[] plusOne(int[] digits) {
        List<Integer> rList = new LinkedList<Integer>();
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry == 1){
                if(digits[i] == 9){
                    rList.add(0);
                }else{
                    rList.add(digits[i]+1);
                    carry=0;
                }
            }else{
                rList.add(digits[i]);
            }
        }
        if(carry == 1){ rList.add(1);}
        if(digits.length == rList.size()){
            int cur = rList.size()-1;
            Iterator<Integer> it = rList.iterator();
            while(it.hasNext()){
                digits[cur] = it.next();   cur--;
            }
            return digits;
        }else{
            int[] res = new int[rList.size()];
            int cur = rList.size()-1;
            Iterator<Integer> it = rList.iterator();
            while(it.hasNext()){
                res[cur] = it.next();   cur--;
            }
            return res;
        }

    }
}
