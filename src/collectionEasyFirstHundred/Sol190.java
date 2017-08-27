package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Reverse Bits
 */
public class Sol190 {
    // Idea: Bit-by-bit reversing, n is unsigned
    public int reverseBits(int n) {
        int res = 0;
        for(int j=0;j<32;j++){
            //Unsigned int 32-bits
            res <<= 1;
            res += (n >>> j) & 1;
        }
        return res;
    }
}
