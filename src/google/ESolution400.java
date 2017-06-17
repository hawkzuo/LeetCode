package google;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Amos on 2017/6/18.
 * Nth Digit 
 */
public class ESolution400 {
    // [9,90,900,9000,90000,900000,9000000,90000000,900000000]
    // [1,2,3,4,5,6,7,8,9]
    //  2,147,483,647
    TreeMap<Integer,Integer> refer;
    public ESolution400(){
        refer = new TreeMap<>();
        int sum = 0;    int count = 9;  int digit = 1;

        while(digit < 9){
            sum += count * digit;
            refer.put(sum,digit);
            count *= 10;    digit ++;
        }

    }


    public int findNthDigit(int n) {
        if(n <= 9 ){    return n;}

        if(refer.containsKey(n)){
            return 9;
        }else{
            // 488889 5
            int lowKey = refer.lowerKey(n);
            int digits = refer.get(lowKey);
            // 100000 100001 100002 ...
            int leftover = n - lowKey;
            int base = 1;
            for(int i=0;i<digits;i++){
                base *= 10;
            }
            base+= leftover / (digits+1);
            int offset = leftover % (digits+1);

            if(offset != 0){
                return (""+base).charAt(offset-1) - '0';
            }else{
                 base --;
                String str = ""+base;
                return str.charAt(str.length()-1) - '0';
            }
        }
    }
    public static void  main(String[] args){
        ESolution400 s = new ESolution400();
        System.out.println(s.findNthDigit(499999));
    }
}
