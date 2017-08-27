package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Number of 1 Bits
 */
public class Sol191 {
    // Idea: Bit-by-bit calculating, n is unsigned
    public int hammingWeight(int n) {
        int count = 0;
        for(int j=0;j<32;j++){
            //Unsigned int 32-bits
            count += (n >> j) & 1;
        }
        return count;
    }
}
