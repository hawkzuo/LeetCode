package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Power of Three
 */
public class Sol326 {
    // Idea: Find the maximum power of three in integer scope and perform 'mod' on it
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
