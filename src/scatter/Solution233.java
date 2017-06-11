//233. Number of Digit One

package scatter;
import java.util.*;
public class Solution233 {
    public int countDigitOne(int n) {
        if(n<=0){   return 0;}
        int d = 0;       
        int cur = n;
        Map<Integer,Integer> rep = new HashMap<Integer,Integer>();
        while(cur != 0){
            d++;
            rep.put(d,cur % 10);
            cur /=10;
        }        
        
        int sum = 0;
        while(d > 0){
            if(!rep.containsKey(d+1)){
               //first digit
               int val = rep.get(d);
               if(val == 1){
                   sum += n;
                   sum -= pw(d-1);
                   sum += 1;
               }else{
                   sum += pw(d-1);
               } 
 
            }else if(!rep.containsKey(d-1)){
               //last digit
               int val = rep.get(d);
               sum += (n/10);
               if(val >= 1){
                   sum +=1;
               }
               break;
            }else{
                //middle digit
                int val = rep.get(d);
                int lval = n;
                for(int i=d;i>=1;i--){
                    lval /= 10;
                }
                
                if(val > 1){
                    lval += 1;
                    sum += lval * pw(d-1);
                }else if(val == 1){
                    int rval = n;
                    rval = rval % pw(d-1);
                    
                    sum += lval * pw(d-1);
                    sum += rval;
                    sum += 1;
                }else{
                    sum += lval * pw(d-1);
                }
            }
            d--;           
        }       
        return sum;        
    }
    private int pw(int n){
        int res = 1;
        while(n>0){
            res *=10;
            n--;
        }
        return res;
    }
}
