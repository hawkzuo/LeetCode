package collectionUtils;

/**
 * Created by Amos on 2017/8/22.
 * TrieNode
 */
public class TrieNode {
    public Character val;
    public TrieNode[] children;
    public boolean includeSelf;
    public TrieNode(Character input){
        val = input;
        children = new TrieNode[26];
        includeSelf=false;
    }
    public String toString(){
        return ""+val;
    }
}
