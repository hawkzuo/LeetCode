package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Length of Last Word
 */
public class Sol058 {
    // Idea: Brute-force Matching
    // Pitfall: Def of 'last' word
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {  return 0;}

        StringBuilder sb = new StringBuilder(s);    sb.reverse();
        int counter = 0;    boolean starting = true;
        for(int i=0; i<sb.length(); i++) {
            if(sb.charAt(i) == ' ') {
                if(starting) {
                    continue;
                }else {
                    break;
                }
            }
            starting = false;
            counter++;
        }
        return counter;
    }
}
