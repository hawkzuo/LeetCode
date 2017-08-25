package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Implement strStr()
 */
public class Sol028 {
    // Idea: Brute-force Matching
    public int strStr(String haystack, String needle) {
        for(int i=0;i<=haystack.length()-needle.length();i++)
            if(haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        return -1;
    }
}
