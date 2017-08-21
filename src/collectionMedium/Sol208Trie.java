package collectionMedium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Amos on 2017/8/21.
 * Implement Trie (Prefix Tree)
 */
public class Sol208Trie {
    TrieNode root;
    int size;
    /** Initialize your data structure here. */
    public Sol208Trie() {
        root = new TrieNode("");
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        int len = word.length();
        TrieNode cur = root;
        char[] str = word.toCharArray();
        for(int i=0;i<len;i++){
            if(cur.children[str[i]-'a'] == null){
                TrieNode newNode = new TrieNode(str[i]);
                cur.children[str[i]-'a'] = newNode;
                cur = newNode;
            }else{
                cur = cur.children[str[i]-'a'];
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
        TrieNode cur = root;
        char[] str = word.toCharArray();
        for(int i=0;i<len;i++){
            if(cur.children[str[i]-'a'] == null){
                return false;
            }else{
                cur = cur.children[str[i]-'a'];
            }
        }
        return cur.includeSelf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }
        int len = prefix.length();
        TrieNode cur = root;
        char[] str = prefix.toCharArray();

        for(int i=0;i<len;i++){
            if(cur.children[str[i]-'a'] == null){
                return false;
            }else{
                cur = cur.children[str[i]-'a'];
            }
        }
        return true;
    }
    //With upperLength constraint version
    public List<String> startsWithAsList(String prefix, int upperLength){
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if(prefix == null || upperLength == 0){ return res;}

        int len = prefix.length();
        TrieNode cur = root;
        char[] str = prefix.toCharArray();
        Deque<TrieNode> queue = new ArrayDeque<TrieNode>();
        for(int i=0;i<len;i++){
            if(cur.children[str[i]-'a'] == null){
                return res;
            }else{
                cur = cur.children[str[i]-'a'];
                path.append(cur.val);
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(cur.children[i] != null){
                queue.offer(cur.children[i] );
                count++;
            }
        }
        if(count == 0){ return res;}

        for(int i=queue.size();i>0;i--){
            TrieNode step = queue.remove();
            dfsSearch(step,path,res,upperLength);
        }
        return res;

    }
    private void dfsSearch(TrieNode root, StringBuilder path, List<String> res, int destLen){
        if(root == null){       return ;}
        path.append(root.val);
        if(path.length() == destLen && root.includeSelf){   res.add(path.toString());}
        else{
            for(int i=0;i<26;i++){
                dfsSearch(root.children[i],path,res,destLen);
            }
        }
        path.deleteCharAt(path.length()-1);
    }


    //Add one method to return a list of strings with prefix, excluding the prefix
    public List<String> startsWithAsList(String prefix){
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        if(prefix == null || prefix.length() == 0){ return res;}
        int len = prefix.length();
        TrieNode cur = root;
        char[] str = prefix.toCharArray();
        Deque<TrieNode> queue = new ArrayDeque<TrieNode>();
        for(int i=0;i<len;i++){
            if(cur.children[str[i]-'a'] == null){
                return res;
            }else{
                cur = cur.children[str[i]-'a'];
                path.append(cur.val);
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(cur.children[i] != null){
                queue.offer(cur.children[i] );
                count++;
            }
        }
        if(count == 0){ return res;}
        //Use DFS instead of BFS
        for(int i=queue.size();i>0;i--){
            TrieNode step = queue.remove();
            dfsSearch(step,path,res);
        }
        return res;
    }
    private void dfsSearch(TrieNode root, StringBuilder path, List<String> res){
        if(root == null){       return ;}
        path.append(root.val);
        if(root.includeSelf){   res.add(path.toString());}
        for(int i=0;i<26;i++){
            dfsSearch(root.children[i],path,res);
        }
        path.deleteCharAt(path.length()-1);
    }


    public static void main(String[] args) {

        Sol208Trie t = new Sol208Trie();
        t.insert("s");
        t.insert("sk");
        t.insert("skl");
        t.insert("skll");
        //t.insert("sklle");
        t.insert("sklleb");
        t.insert("skllee");
        t.insert("skllebe");
        t.insert("sklleee");
        System.out.println(t.startsWithAsList("skll",6));
    }



}
