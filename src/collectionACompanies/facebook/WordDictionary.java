package collectionACompanies.facebook;
import java.util.*;

class TreNode{
    boolean isRoot=false;
    int wholeLen;
    Map<Character,TreNode> children;
    Character value;
    public TreNode(int len){
        isRoot = true;
        wholeLen = len;
        children = new HashMap<Character,TreNode>();
    }
    public TreNode(char input){
        isRoot = false;
        children = new HashMap<Character,TreNode>();
        value = input;
    }
}




public class WordDictionary {

    int wordCount;
    Map<Integer,TreNode> roots;

    /** Initialize your data structure here. */
    public WordDictionary() {
        roots = new HashMap<Integer,TreNode>();
        wordCount=0;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0 ){    return;}
        int len = word.length();
        TreNode pos = null;
        
        if(roots.containsKey(len) ){
            pos = roots.get(len);
        }else{
            pos = new TreNode(len);
            roots.put(len, pos);
        }
        
        
        for(int i=0;i<len;i++){
            char toAdd = word.charAt(i);
            
            if(pos.children.containsKey(toAdd) ){
                pos = pos.children.get(toAdd);
            }else{
                TreNode newnode = new TreNode(toAdd);
                pos.children.put(toAdd,newnode);
                pos = newnode;
            }
            
        }
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        int len = word.length();
        TreNode pos = null;
        if(!roots.containsKey(len) ){
           return false;
        }else{
            pos = roots.get(len);
        }
        
        Deque<TreNode> queue = new ArrayDeque<TreNode>();
        queue.offer(pos);
        for(int i=0;i<len;i++){
            char toCheck = word.charAt(i);
            int qLen = queue.size();
            if(toCheck == '.'){
                for(int k=0;k<qLen;k++){
                    TreNode step = queue.remove();
                    for(Character dummyC: step.children.keySet()){
                        queue.offer(step.children.get(dummyC));
                    }
                }
            }else{
                for(int k=0;k<qLen;k++){
                    TreNode step = queue.remove();
                    if(step.children.containsKey(toCheck) ){
                        queue.offer(step.children.get(toCheck));
                    }
                }                
            }
            
            if(queue.size() == 0){
                return false;
            }
        }
        
            if(queue.size() == 0){
                return false;
            }else{
                return true;
            }        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		wd.addWord("bbb");
		System.out.println(wd.search("pad"));
		System.out.println(wd.search("bad"	));
		System.out.println(wd.search(".ad"));
		System.out.println(wd.search(".bb"));
		
		
		
		
	}    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

