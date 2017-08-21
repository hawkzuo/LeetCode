package collectionTopics.trie;

/**
 * Created by Amos on 2017/8/21.
 * Char-based implementation of TrieNode
 */
public class TrieNode {
    Character val;
    TrieNode[] children;
    boolean includeSelf;
    public TrieNode(Character input){
        val = input;
        children = new TrieNode[26];
        includeSelf=false;
    }
    public String toString(){
        return ""+val;
    }
}
