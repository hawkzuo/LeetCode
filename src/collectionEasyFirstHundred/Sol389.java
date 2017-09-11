package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Find the Difference
 */
public class Sol389 {
    // Idea: Bit-manipulation will be faster
    public char findTheDifference(String s, String t) {
        char[] sc =s.toCharArray();
        char[] tc =t.toCharArray();
        int res = 0;
        for (char aSc : sc) {
            res ^= aSc;
        }
        for (char aTc : tc) {
            res ^= aTc;
        }
        return (char)res;
    }
}
