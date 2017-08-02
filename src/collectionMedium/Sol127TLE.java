package collectionMedium;

import java.util.*;

/**
 * Created by Amos on 2017/7/31.
 * Word Ladder
 */
public class Sol127TLE {

    private int globalMin = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        globalMin = Integer.MAX_VALUE;

        int wordLen = endWord.length();
        Map<Character, Set<String>>[] refer = new HashMap[wordLen];
        for(int i=0;i<wordLen;i++) {
            refer[i] = new HashMap<>();
        }
        // Initialize table
        for(String word: wordList) {
            char[] str = word.toCharArray();
            for(int i=0;i<str.length;i++) {
                if(refer[i].containsKey(str[i])) {
                    refer[i].get(str[i]).add(word);
                }else{
                    Set<String> dummy = new HashSet<>();
                    dummy.add(word);
                    refer[i].put(str[i], dummy);
                }
            }
        }
        bfsHelper(beginWord, new HashSet<>(), refer, endWord);
        if(globalMin == Integer.MAX_VALUE){ result = 0;}
        else{ result = globalMin;}
        return result;
    }

    private void bfsHelper(String currentWord, Set<String> selected, Map<Character, Set<String>>[] refer, String endWord) {

        Set<String> nextLevelPotentials = new HashSet<>();
        char[] cur = currentWord.toCharArray();

        for(int i=0;i<refer.length;i++){
            Map<Character, Set<String>> ith = refer[i];
            for(Character ch: ith.keySet()) {
                if(cur[i] == ch) {  continue;}
                Set<String> possibleChoices = ith.get(ch);
                for(String possibleNextChoice: possibleChoices) {
                    if(!selected.contains(possibleNextChoice) && isQualified(i, possibleNextChoice, currentWord)) {
                        nextLevelPotentials.add(possibleNextChoice);
                        if(possibleNextChoice.equals(endWord)) {
                            // Cal and return
                            globalMin = Math.min(globalMin, selected.size()+2);
                            return;
                        }
                    }
                }
            }
        }

        // Proceed to next level
        for(String next: nextLevelPotentials) {
            selected.add(next);
            bfsHelper(next, selected, refer, endWord);
            selected.remove(next);
        }
    }

    private boolean isQualified(int replaceBit, String str1, String str2) {
        int len = str1.length();
        if(replaceBit < 0 || replaceBit >= len) {   return false;}
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0;i<len;i++) {
            if(i == replaceBit){ continue;}
            if(ch1[i] != ch2[i]){ return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        Sol127TLE s = new Sol127TLE();
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(s.ladderLength("hit", "cog", words));
    }
}
