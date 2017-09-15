package collectionHardFirstFifty;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Amos on 9/14/17.
 * Substring with Concatenation of All Words
 */
public class Sol030 {

    // Cases:
//    s: "barfoothefoobarman"
//    words: ["foo", "bar"]       =>      0,9
//    "ababaab"   ["ab","ba","ba"]    =>  1     a babbaaabb    (bab,baa,abb)
//    "aaaaaaaa"  ["aa","aa","aa"]    =>  0,1,2

//   A new idea via sliding windows






    public List<Integer> findSubstringOld(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0 || words[0].length() == 0 || s.length()< words[0].length()*words.length ){
            return result;
        }

        Map<String, Integer> reference = new HashMap<>();
        for(String word: words) {
            if(reference.containsKey(word)) {
                reference.put(word, reference.get(word) + 1);
            } else {
                reference.put(word, 1);
            }
        }


        // The only way remains is to check each window one step by one step
        for(int i=0; i + words[0].length()*words.length <= s.length(); i++) {
            String sub = s.substring(i, i + words[0].length()*words.length);
            if(matchBrute(sub, reference, words[0].length())) {
                result.add(i);
            }
        }

        return result;
    }






    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0 || words[0].length() == 0 || s.length()< words[0].length()*words.length ){
            return result;
        }

        Map<String, Integer> reference = new HashMap<>();
        for(String word: words) {
            if(reference.containsKey(word)) {
                reference.put(word, reference.get(word) + 1);
            } else {
                reference.put(word, 1);
            }
        }


        // The only way remains is to check each window one step by one step
        for(int i=0; i < words[0].length(); i++) {
            Map<String, Integer> dummy = deepCopy(reference);
            matchViaSliding(s, i, dummy, words[0].length(), words.length, result);
        }

        return result;
    }

    private Map<String, Integer> deepCopy(Map<String, Integer> reference) {
        Map<String, Integer> res = new HashMap<>();
        for(String s: reference.keySet()) {
            res.put(s, reference.get(s));
        }
        return res;
    }


    // Require detailed analysis
    // Time O(N/k) *O(k) = O(N)
    private void matchViaSliding(String str, int offset, Map<String, Integer> reference, int wordLength, int totalWords, List<Integer> result) {
//    "ababaab"   ["ab","ba","ba"]
        // matchedCount
        if(offset+wordLength * totalWords > str.length()) {
            return;
        }
        int matchedCount = 0;
        int desiredCount = reference.size();

        // ref means the demand count for such word
        String initial = str.substring(offset, offset+wordLength * totalWords);
        for(int i=offset; i<offset+wordLength * totalWords; i+=wordLength) {
            String step = str.substring(i, i+wordLength);
            if(reference.containsKey(step)) {
                int remains = reference.get(step);
                if(remains == 1) {
                    matchedCount ++;
                } else if (remains == 0) {
                    matchedCount --;
                }
                reference.put(step, remains-1);
            }
        }

        if(matchedCount == desiredCount) {
            result.add(offset);
        }

        // MainLoop
        for(int i=offset + wordLength; i+wordLength * totalWords<=str.length(); i+=wordLength) {
            String toRemove = str.substring(i-wordLength, i);
            String toAdd = str.substring(i+wordLength * totalWords - wordLength , i+wordLength * totalWords);
            if(reference.containsKey(toRemove)) {
                int remains = reference.get(toRemove);
                if(remains == -1) {
                    matchedCount ++;
                } else if(remains == 0) {
                    matchedCount --;
                }
                reference.put(toRemove, remains+1);
            }
            if(reference.containsKey(toAdd)) {
                int remains = reference.get(toAdd);
                if(remains == 1) {
                    matchedCount ++;
                } else if (remains == 0) {
                    matchedCount --;
                }
                reference.put(toAdd, remains-1);
            }
            if(matchedCount == desiredCount) {
                result.add(i);
            }
        }
    }



    // Match with backtracking
    private boolean matchBrute(String str, Map<String, Integer> reference, int wordLength) {
        return matchWithBT(str, 0, reference, wordLength);
    }


    private boolean matchWithBT(String input, int curIndex, Map<String, Integer> reference, int wordLength) {
        if(curIndex == input.length()) {
            return true;
        }
        String toCheck = input.substring(curIndex, curIndex+wordLength);
        if(!reference.containsKey(toCheck)) {
            return false;
        } else {
            int leftovers = reference.get(toCheck);
            if(leftovers <= 0) {
                return false;
            } else {
                // Move down to one step and BT
                reference.put(toCheck, leftovers-1);
                boolean res = matchWithBT(input, curIndex+wordLength, reference, wordLength);
                // BT:
                reference.put(toCheck, leftovers);
                return res;
            }
        }
    }




    public static void main(String[] args) {
        Sol030 s = new Sol030();

//    s: "barfoothefoobarman"
//    words: ["foo", "bar"]       =>      0,9
//    "ababaab"   ["ab","ba","ba"]    =>  1     a babbaaabb    (bab,baa,abb)
//    "aaaaaaaa"  ["aa","aa","aa"]    =>  0,1,2
//        "wordgoodgoodgoodbestword"
//                ["word","good","best","good"]
        long t1 = System.currentTimeMillis();
        String str = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        String [] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};


//        String str = "aaaaaaaa";
//        String[] words = {"aa","aa","aa"};

        System.out.println(s.findSubstring(str, words));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
