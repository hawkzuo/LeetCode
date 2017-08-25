package collectionEasyFirstHundred;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amos on 2017/8/25.
 * Plus One
 */
public class Sol066 {
    // Idea: Brute-force Adding
    //     LinkedList iterator
    public int[] plusOne(int[] digits) {
        List<Integer> resultList = new LinkedList<>();
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry == 1){
                if(digits[i] == 9){
                    resultList.add(0);
                }else{
                    resultList.add(digits[i]+1);
                    carry=0;
                }
            }else{
                resultList.add(digits[i]);
            }
        }
        if(carry == 1){ resultList.add(1);}
        if(digits.length == resultList.size()){
            int cur = resultList.size()-1;
            Iterator<Integer> it = resultList.iterator();
            while(it.hasNext()){
                digits[cur] = it.next();   cur--;
            }
            return digits;
        }else{
            int[] res = new int[resultList.size()];
            int cur = resultList.size()-1;
            Iterator<Integer> it = resultList.iterator();
            while(it.hasNext()){
                res[cur] = it.next();   cur--;
            }
            return res;
        }
    }
}
