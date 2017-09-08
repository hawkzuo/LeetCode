package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Sum of Two Integers
 */
public class Sol371 {
    // Idea: Bit-by-bit adding via logic operations
    // Full-Adder Design
    // Deep implementation at digital circuit level
    public int getSum(int a, int b) {
        int c = 0;
        int res =0;
        for(int i=0;i<32;i++){
            int an = (a >> i) & 1;
            int bn = (b >> i) & 1;
            res ^= ((~an&~bn&c)|(~an&bn&~c)|(an&~bn&~c)|(an&bn&c)) << i;
            c = (an&bn&c)|(an&bn&~c)|(an&~bn&c)|(~an&bn&c);

        }
        return res;
    }
}
