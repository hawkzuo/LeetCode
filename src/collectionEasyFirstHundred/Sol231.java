package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/2.
 * Power of Two
 */
public class Sol231 {
    // Idea: Math
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
}
