package trie;
import java.util.*;
public class Solution336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0){  return result;}
        //Double everything on Initialization
        Map<String,Integer> table = new HashMap<String,Integer>();
        Map<String,Integer> reversedTable = new HashMap<String,Integer>();
        Trie rtree = new Trie();
        int nullIndex = -1;
        for(int i=0;i<words.length;i++){
            String cur = words[i];
            if(cur == null){    continue;}
            if(cur.length() == 0){
                nullIndex = i;
            }else{
                String currev = new StringBuilder(cur).reverse().toString();
                table.put(cur,i);   reversedTable.put(currev,i);
                rtree.insert(currev);                
            }
        }
        //Main For Loop:
        for(String str: words){
            //Bug correction    --Case:""
            if(str == null || str.length() == 0){
                continue;
            }
            int lIndex = table.get(str);
            int len = str.length();
            //First check if left String is longer
            for(int cursor = 0;cursor<len;cursor++){
                String toCheck = str.substring(0,cursor+1);
                if(rtree.search(toCheck)){
                    //Check Palindrome
                	if(checkPalindrome(str.substring(cursor+1,len))){
                        List<Integer> dummy = new ArrayList<Integer>();
                        int rIndex = reversedTable.get(toCheck);
                        //Bug correction    --Case:distinct pair
                        if(lIndex != rIndex){
                            dummy.add(lIndex);  dummy.add(rIndex);
                            result.add(dummy);
                        }                		
                	}
                }
            }
            //Then check for situation that right String is longer
            List<String> potentials = rtree.startsWithAsList(str);
            for(String possible: potentials){
                int bigLen = possible.length();
                if(bigLen-len == 1 || checkPalindrome(possible.substring(len,bigLen)) ){
                    //Found
                    List<Integer> dummy = new ArrayList<Integer>();
                    int rIndex = reversedTable.get(possible);
                    dummy.add(lIndex);  dummy.add(rIndex);
                    result.add(dummy);
                }
            }
        }
        //Now take care of null situation
        if(nullIndex != -1){
            for(int i=0;i<words.length;i++){
                if(i == nullIndex){ continue;}
                String cur = words[i];
                if(cur == null){    continue;}
                if(checkPalindrome(cur)){
                    List<Integer> dummy1 = new ArrayList<Integer>();    dummy1.add(i);  dummy1.add(nullIndex);
                    result.add(dummy1);  List<Integer> dummy2 = new ArrayList<Integer>();
                    dummy2.add(nullIndex);  dummy2.add(i);  result.add(dummy2);  
                }
            }
        }
        return result;
    }
    private boolean checkPalindrome(String input){
        //Assume input is valid
        int len = input.length();
        char[] str = input.toCharArray();
        for(int i=0;i<len/2;i++){
            if(str[i] != str[len-1-i]){
                return false;
            }
        }
        return true;
    }
    /*
    private int getLastNonRepeat(String input){
        //Assume input is valid
        int len = input.length();
        char[] str = input.toCharArray();
        int result = len-1; char refer = str[result];
        
        for(int i=len-2;i>=0;i--){
            if(str[i] == refer){
                result--;
            }else{
                return result-1;
            }
        }
        return result-1;
    }
    */
    public static void main(String[] args) {
    	Solution336 s = new Solution336();
    	String[] words = {"baaabab","aaaaba","babbb","b","babaaab","baabaa","ba","ababa","abbaaa","aababaaa","aabba","ababaaab","babab","bb","aa","aaaaabba","abba","babbbaa","baaba","aaabb"};
    	System.out.println(s.palindromePairs(words));
    }

}
