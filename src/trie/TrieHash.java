package trie;
import java.util.*;


class TrieNode1{
    String val;
    //Use Character as key
    Map<String,TrieNode1> children;
    boolean includeSelf;
    public TrieNode1(String input){
        val = input;
        children = new HashMap<String,TrieNode1>();
        includeSelf=false;
    }
    public TrieNode1(char input){
        val = ""+input;
        children = new HashMap<String,TrieNode1>();
        includeSelf=false;
    }
    public String toString(){
        return ""+val;
    }
}


public class TrieHash {
    
    TrieNode1 root;
    int size;
    
    /** Initialize your data structure here. */
    public TrieHash() {
        root = new TrieNode1("");
        size = 0;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        int len = word.length();
        
        TrieNode1 cur = root;
        char[] str = word.toCharArray();
        for(int i=0;i<len;i++){
            if(!cur.children.containsKey(""+str[i]) ){
                TrieNode1 nnode = new TrieNode1(str[i]);
                cur.children.put(""+str[i],nnode);
                cur = nnode;
            }else{
                cur = cur.children.get(""+str[i]);
            }
        }
        cur.includeSelf = true;
        
        size++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return true;
        }        
        
        int len = word.length();
        
        TrieNode1 cur = root;
        char[] str = word.toCharArray();
        
        for(int i=0;i<len;i++){
            if(!cur.children.containsKey(""+str[i]) ){
                return false;
            }else{
                cur = cur.children.get(""+str[i]);
            }
        }
        if(cur.includeSelf){    return true;}
        else{   return false;}
        
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }        
        int len = prefix.length();  
        TrieNode1 cur = root;
        char[] str = prefix.toCharArray();        
        
        for(int i=0;i<len;i++){
            if(!cur.children.containsKey(""+str[i]) ){
                return false;
            }else{
                cur = cur.children.get(""+str[i]);
            }            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	TrieHash t = new TrieHash();
    	t.search("");
    	t.insert("tea");
    	t.search("te");
    	t.startsWith("t");
    }
}
