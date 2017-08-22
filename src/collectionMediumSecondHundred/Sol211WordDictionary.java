package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/8/22.
 * Add and Search Word - Data structure design
 */
public class Sol211WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Sol211WordDictionary() {
        root = new TrieNode(null);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0){
            return;
        }

        char[] str = word.toCharArray();
        TrieNode current = root;

        for (char step : str) {
            if (current.children[step - 'a'] == null) {
                TrieNode newNode = new TrieNode(step);
                current.children[step - 'a'] = newNode;
                current = newNode;
            } else {
                current = current.children[step - 'a'];
            }
        }
        current.includeSelf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0 ){    return true;}

        char[] str = word.toCharArray();

        return wildSearchHelper(str, 0, root);
    }

    private boolean wildSearchHelper(char[] str, int curIndex, TrieNode current) {

        if(curIndex == str.length) {
            return current.includeSelf;
        }

        char stepChar = str[curIndex];
        boolean result = false;

        if(stepChar == '.') {
            for(TrieNode posNext: current.children) {
                if(posNext == null) {   continue;}
                result |= wildSearchHelper(str, curIndex+1, posNext);
            }
        } else {
            TrieNode posNext = current.children[stepChar - 'a'];
            if(posNext != null) {
                result = wildSearchHelper(str, curIndex + 1, posNext);
            }
        }
        return result;
    }
}
