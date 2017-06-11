package scatter;

import java.util.List;
import java.util.*;
public class Solution066 {

    public int[] plusOne(int[] digits) {
        List<Integer> rlist = new LinkedList<Integer>();
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry == 1){
                if(digits[i] == 9){
                    rlist.add(0);
                }else{
                    rlist.add(digits[i]+1);
                    carry=0;
                }
            }else{
            	rlist.add(digits[i]);
            }
        }
        if(carry == 1){ rlist.add(1);}
        if(digits.length == rlist.size()){
            int cur = rlist.size()-1;
            Iterator<Integer> it = rlist.iterator();
            while(it.hasNext()){
                digits[cur] = it.next();   cur--;
            }   
            return digits;
        }else{
            int[] res = new int[rlist.size()];  
            int cur = rlist.size()-1;
            Iterator<Integer> it = rlist.iterator();
            while(it.hasNext()){
                res[cur] = it.next();   cur--;
            }
            return res;
        }
        
    }
}
