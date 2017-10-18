package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/13.
 * Longest Palindromic Substring
 */
public class Sol005 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int max = 0;
        int leftIndex = -1;
        int rightIndex = -2;
        // D[i][j] represents that whether substring palindromic between i j
        boolean[][] D = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                D[i][j] = s.charAt(i) == s.charAt(j) && (j - i <=
                        2 || D[i + 1][j - 1]);
                if (D[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        leftIndex=i;
                        rightIndex=j+1;
                    }
                }
            }
            System.out.println();
        }
        return s.substring(leftIndex,rightIndex);
    }
}
