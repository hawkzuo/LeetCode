package collectionATopics.trie;

import collectionUtils.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/21.
 * Char-based implementation of Trie
 */
public class Trie {
    private TrieNode root;
    private int size;
    public Trie() {
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
        TrieNode correctNode = exactSearch(word);
        return correctNode != null && correctNode.includeSelf;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean wildcardSearch(String word) {
        if(word == null || word.length() == 0 ){    return true;}

        char[] str = word.toCharArray();

        return wildSearchHelper(str, 0, root);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }

        TrieNode correctNode = exactSearch(prefix);
        return correctNode != null;
    }

    /** Returns a list of strings begins with the prefix, excluding the prefix if it's in the dictionary, with exactly
     *  'desiredLength' long
     */
    public List<String> startsWithAsList(String prefix, int desiredLength){
        List<String> res = new ArrayList<>();
        if(prefix == null || prefix.length() == 0) {    return res;}

        TrieNode correctNode = exactSearch(prefix);
        if(correctNode == null) {   return res;}

        StringBuilder sb = new StringBuilder(prefix);
        List<TrieNode> possibleStarters = new ArrayList<>();
        for(int i=0;i<26;i++) {
            if(correctNode.children[i] != null) {
                possibleStarters.add(correctNode.children[i]);
            }
        }
        if(possibleStarters.size() == 0) {   return res;}

        for(TrieNode root: possibleStarters) {
            dfsVisit(res, sb, root, desiredLength);
        }
        return res;
    }

    /** Returns a list of strings begins with the prefix, excluding the prefix if it's in the dictionary */
    public List<String> startsWithAsList(String prefix) {
        List<String> res = new ArrayList<>();
        if(prefix == null || prefix.length() == 0) {    return res;}

        TrieNode correctNode = exactSearch(prefix);
        if(correctNode == null) {   return res;}

        StringBuilder sb = new StringBuilder(prefix);
        List<TrieNode> possibleStarters = new ArrayList<>();
        // Find out children needed to proceed search on
        for(int i=0;i<26;i++) {
            if(correctNode.children[i] != null) {
                possibleStarters.add(correctNode.children[i]);
            }
        }
        if(possibleStarters.size() == 0) {   return res;}

        for(TrieNode root: possibleStarters) {
            dfsVisit(res, sb, root);
        }
        return res;
    }

    /** Brute-force searching with exact matching  */
    private TrieNode exactSearch(String word) {
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

    /** DFS Helper for searching with wildcard matching */
    private boolean wildSearchHelper(char[] str, int curIndex, TrieNode current) {

        if(curIndex == str.length) {
            return current.includeSelf;
        }

        char stepChar = str[curIndex];
        boolean result = false;

        if(stepChar == '.') {
            for(TrieNode posNext: current.children) {
                if(posNext == null) {   continue;}
                result |= wildSearchHelper(str, curIndex + 1, posNext);
            }
        } else {
            TrieNode posNext = current.children[stepChar - 'a'];
            if(posNext != null) {
                result = wildSearchHelper(str, curIndex + 1, posNext);
            }
        }
        return result;
    }

    /** Use DFS to form all the words without bound */
    private void dfsVisit(List<String> res, StringBuilder path, TrieNode root) {
        path.append(root.val);
        if(root.includeSelf) {
            res.add(path.toString());
        }
        for(TrieNode next: root.children) {
            if(next == null) {  continue;}
            dfsVisit(res, path, next);
        }
        path.deleteCharAt(path.length()-1);
    }

    /** Use DFS to form all the words with exact bound */
    private void dfsVisit(List<String> res, StringBuilder path, TrieNode root, int desiredLength) {
        path.append(root.val);
        if(root.includeSelf && path.length() == desiredLength) {
            res.add(path.toString());
        }
        if(path.length() < desiredLength) {
            for (TrieNode next : root.children) {
                if (next == null) {
                    continue;
                }
                dfsVisit(res, path, next);
            }
        }
        path.deleteCharAt(path.length()-1);
    }

    public static void main(String[] args) {

        Trie t = new Trie();
        t.insert("s");
        t.insert("sk");
        t.insert("skl");
        t.insert("skll");
        //t.insert("sklle");
        t.insert("sklleb");
        t.insert("skllee");
        t.insert("skllebe");
        t.insert("sklleee");
        System.out.println(t.startsWithAsList("skll", 5));
    }

}
