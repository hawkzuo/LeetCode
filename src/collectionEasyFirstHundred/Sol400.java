package collectionEasyFirstHundred;

import java.util.TreeMap;

/**
 * Created by Amos on 2017/9/10.
 * Nth Digit
 */
public class Sol400 {
    // Idea: Store Max number of possible n that each k-digit number could be, and save it to the Map.
    // This helps determine how many numbers this n should be in, then deals with leftovers.

    //  # of numbers :  [9,90,900,9000,90000,900000,9000000,90000000,900000000]
    //  digits:         [1,2,3,4,5,6,7,8,9]
    //  2,147,483,647
    private TreeMap<Integer,Integer> refer;
    public Sol400(){
        refer = new TreeMap<>();
        // Construct Map
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
            // Now base will be the number, what's left is find the offset position
            // Take care of offset
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
}
