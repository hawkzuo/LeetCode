package trie;
import java.util.*;
public class Solution425 {

    private int Dim;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.length == 0){ return res;}
        Trie tr = new Trie();   for(String word: words){    tr.insert(word);}
        Dim = words[0].length();
        
        char[][] selected = new char[Dim][Dim];
        String[] prefixes = new String[Dim];
        int curstep = 0;        
        for(String word: words){           
            dfs(word,selected,curstep,prefixes,tr,res);           
        }
        return res;
    }
    
    private void dfs(String curstepWord, char[][] selected, int curstep, String[] prefixes, Trie tr,List<List<String>> res){
        selected[curstep] = curstepWord.toCharArray();
        if(curstep == Dim-1){
            //Add to end
            List<String> toAdd = new ArrayList<String>();
            for(int i=0;i<selected.length;i++){
                toAdd.add(String.valueOf(selected[i]));
            }
            res.add(toAdd);
        }else{        
            StringBuilder sb = new StringBuilder();
            //This part is the core backtracking idea of this algorithm
            for(int dummy = 0; dummy <curstep+1; dummy++){
                sb.append(selected[dummy][curstep+1]);
            }
            prefixes[curstep+1] = sb.toString();        
            List<String> nextIters = tr.startsWithAsList(prefixes[curstep+1],Dim);
            if(nextIters.size() == 0){
                ;
            }else{
                for(String possible: nextIters){
                    dfs(possible,selected,curstep+1,prefixes,tr,res);
                }
            }
            //
        }
        //BT
        selected[curstep] = new char[Dim];
        if(curstep != Dim -1){
            prefixes[curstep+1]= "";
        }
    }

}
