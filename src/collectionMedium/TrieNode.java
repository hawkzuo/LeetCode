package collectionMedium;

/**
 * Created by Amos on 2017/8/21.
 */
public class TrieNode {

        String val;
        TrieNode[] children;
        boolean includeSelf;
        public TrieNode(String input){
            val = input;
            children = new TrieNode[26];
            includeSelf=false;
        }
        public TrieNode(char input){
            val = ""+input;
            children = new TrieNode[26];
            includeSelf=false;
        }
        public String toString(){
            return ""+val;
        }

}
