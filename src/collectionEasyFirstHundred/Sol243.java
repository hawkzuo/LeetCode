package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/4.
 * Shortest Word Distance
 */
public class Sol243 {
    // Idea: Wants to use Map at first, but realize the greedy choice
    public int shortestDistance(String[] words, String word1, String word2) {
        Integer index1 = null;
        Integer index2 = null;
        int result = Integer.MAX_VALUE;
        for(int i=0; i< words.length; i++) {
            String step = words[i];
            if(step.equals(word1)) {
                index1 = i;
            } else if(step.equals(word2)) {
                index2 = i;
            }
            if(index1!=null && index2!=null) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
}
