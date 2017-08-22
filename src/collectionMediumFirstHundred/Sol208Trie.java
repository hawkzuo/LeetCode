package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/21.
 * Implement Trie (Prefix Tree)
 */

class TrieNode {
    Character val;
    TrieNode[] children;
    boolean includeSelf;
    public TrieNode(Character input){
        val = input;
        children = new TrieNode[26];
        includeSelf=false;
    }
}

public class Sol208Trie {
    TrieNode root;
    int size;
    /** Initialize your data structure here. */
    public Sol208Trie() {
        root = new TrieNode(null);
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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
        size ++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode correctNode = bruteVisit(word);
        return correctNode != null && correctNode.includeSelf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }
        TrieNode correctNode = bruteVisit(prefix);
        return correctNode != null;
    }

    private TrieNode bruteVisit(String word) {
        char[] str = word.toCharArray();
        TrieNode current = root;
        for (char step : str) {
            if (current.children[step - 'a'] == null) {
                return null;
            } else {
                current = current.children[step - 'a'];
            }
        }
        return current;
    }
}
