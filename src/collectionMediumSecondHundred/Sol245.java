package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/9/4.
 * Shortest Word Distance III
 */
public class Sol245 {
    // Idea: Equal case is simpler than the original case, in fact.
    //      Thus, separate into two methods will work
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
            return shortestDistanceOne(words, word1);
        }
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

    private int shortestDistanceOne(String[] words, String refer) {
        Integer prev = null;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++) {
            String step = words[i];
            if(step.equals(refer)) {
                if(prev == null) {
                    prev = i;
                } else {
                    result = Math.min(result, i-prev);
                    prev = i;
                }
            }
        }
        return result;
    }
}
