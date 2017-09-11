package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Ransom Note
 */
public class Sol383 {
    // Idea: I might want to sort, have a try, but failed.
    // For example, sorted will be "abbbbccc" and "bc", not quite suitable for this case

    // Second Idea: Bucket sort. Record each char occurrences and compare them. Quite good idea
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    // O(n^2) algorithm, brute-force matching
    public boolean canConstructOld(String ransomNote, String magazine) {
        char[] notes=ransomNote.toCharArray();
        char[] mag=magazine.toCharArray();
        for (char step : notes) {
            int j = 0;
            while (j < mag.length && mag[j] != step) {
                j++;
            }
            if (j >= mag.length) {
                return false;
            } else {
                mag[j] = ' ';
            }
        }
        return true;
    }
}
