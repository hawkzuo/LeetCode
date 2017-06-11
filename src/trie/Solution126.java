package trie;
import java.util.*;
class hNode{
	int len;
	Map<String,Integer> pathRec;
	List<String> path;
	String value;
	public hNode(String in){
		len = 0;
		pathRec = new HashMap<String,Integer>();
		path = new ArrayList<String>();
		value = in;
	}
}

public class Solution126 {
    
	private int Dim;
	//private Trie[] trees;
	private int minLen;
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<String> resList = new ArrayList<String>();	resList.add(beginWord);
		List<List<String>> Res = new ArrayList<List<String>>();
    	minLen = Integer.MAX_VALUE;
    	Dim = endWord.length();
    	//Construct refTable
    	//Take care of 1-dim case
    	if(Dim == 1){
    		for(String str: wordList){
    			if(str.equals(endWord)){
    				resList.add(str);
    				Res.add(resList);
    				return Res;
    			}
    		}
    		return Res;
    	}
    	
    	String[] wordArray = new String[wordList.size()];
    	Map<String,Integer> refTable = new HashMap<String,Integer>();
    	Map<String,Integer> selTable = new HashMap<String,Integer>();
    	for(int i=0;i<wordList.size();i++){
    		wordArray[i] = wordList.get(i);
    		refTable.put(wordArray[i], i);
    	}
    	
    	Map<String, Integer>[] refTables = new HashMap[Dim];
    	refTables[Dim-1] = refTable;
    	
    	//Trie[] trees = new Trie[Dim];
    	Map<String, Map<String,Integer>>[] trees = new HashMap[Dim];
    	constructTrees(wordList,wordArray,refTables,trees);
    	
    	Deque<hNode> queue = new ArrayDeque<hNode>();
    	hNode root = new hNode(beginWord);	root.path.add(beginWord);
    	queue.offer(root);
    	
    	int optD = -1;
    	while(!queue.isEmpty()){
    		int ops = queue.size();
    		boolean endFlag = false;
    		for(int i=0;i<ops;i++){
    			hNode prev = queue.remove();
    			String curStep = prev.value;	Map<String,Integer> oldPath = prev.pathRec;	List<String> op = prev.path;
    			if(curStep.equals(endWord)){
    				endFlag = true; optD = prev.len;
    				//Add up
    				List<String> dummy = new ArrayList<String>();
    				for(int i1=0;i1<op.size();i1++){
    					dummy.add(op.get(i1));
    				}	
    				Res.add(dummy);
    				continue;
    			}
    			for(int repCursor = 0; repCursor<Dim; repCursor++){			
    				StringBuilder sb;
    				if(repCursor == Dim - 1){	sb = new StringBuilder();}
    				else{	sb = new StringBuilder(curStep.substring(repCursor+1)); }
    				if(repCursor>0){
    					sb.append(curStep.substring(0, repCursor));
    				}				
    				String fKey = sb.toString();
    				
    				Map<String, Integer> raws = trees[repCursor].get(fKey);
    				if(raws == null){	continue;}
    				List<String> cands = new ArrayList<String>();				
    				for(String dummy: raws.keySet()){
    					String realStr = wordArray[refTables[repCursor].get(dummy)];
    					if(!oldPath.containsKey(realStr)){
    						cands.add(realStr);
    					}
    				}				
    				for(String toTry: cands){
    						//Mark selected
    						hNode nnode = new hNode(toTry);
    						nnode.len = prev.len+1;	nnode.pathRec.put(toTry, 1);
    						for(String refstr: oldPath.keySet()){
    							nnode.pathRec.put(refstr, 1);
    						}
    						nnode.path=new ArrayList<String>(op);	nnode.path.add(toTry);
    						queue.offer(nnode);
    				}
    			}
    		}   			   			
    		if(endFlag){break;}
    	}    	
    	if(optD == -1){return Res;}
    	
    	
 /*   	
    	constructPaths(wordArray,refTables,selTable,resList,endWord,Res,trees,beginWord,optD);

    	Iterator<List<String>> it = Res.iterator();
    	while(it.hasNext()){
    		List<String> cStep = it.next();
    		if(cStep.size()>minLen){
    			it.remove();
    		}
    	}
 */   	
    	return Res;
    }
    
	private void constructPaths(String[] wordArray, Map<String,Integer>[] refTables, Map<String,Integer> selTable, 
			List<String> resList, String endWord, List<List<String>> Res, Map<String, Map<String,Integer>>[] trees, String curStep, int optD){
		//System.out.println(resList.size());
		//System.out.println(Res.size());
		//Must use .equals in LeetCode
		if(resList.size() > optD+1){
			String toRem = resList.get(resList.size()-1);
			selTable.remove(toRem);
			resList.remove(resList.size()-1);				
			return;
		}
		
		if(curStep.equals(endWord)){	
			List<String> dummy = new ArrayList<String>();
			for(int i=0;i<resList.size();i++){
				dummy.add(resList.get(i));
			}			
			if(dummy.size() <= optD+1){Res.add(dummy);}
			minLen = Math.min(minLen, dummy.size());
			
			String toRem = resList.get(resList.size()-1);
			selTable.remove(toRem);
			resList.remove(resList.size()-1);			
			return;
		}

		for(int repCursor = 0; repCursor<Dim; repCursor++){			
				StringBuilder sb;
				if(repCursor == Dim - 1){	sb = new StringBuilder();}
				else{	sb = new StringBuilder(curStep.substring(repCursor+1)); }
				if(repCursor>0){
					sb.append(curStep.substring(0, repCursor));
				}				
				String fKey = sb.toString();
				
				Map<String, Integer> raws = trees[repCursor].get(fKey);
				if(raws == null){	continue;}
				List<String> cands = new ArrayList<String>();				
				for(String dummy: raws.keySet()){
					String realStr = wordArray[refTables[repCursor].get(dummy)];
					if(!selTable.containsKey(realStr)){
						cands.add(realStr);
					}
				}				
				//2 cases
				if(cands.size() == 0){
					//Nothing left; nothing need to change
					;
				}else{
					for(String toTry: cands){
						//Mark selected						
						selTable.put(toTry, 1);
						resList.add(toTry);						
						constructPaths(wordArray,refTables,selTable,resList,endWord,Res,trees,toTry,optD);
					}
				}									
		}
		
		//BT:
		String toRem = resList.get(resList.size()-1);
		selTable.remove(toRem);
		resList.remove(resList.size()-1);
		
	}
	
	
	
	
	private void constructTrees(List<String> wordList, String[] wordArray, Map<String, Integer>[] refTables, Map<String, Map<String,Integer>>[] trees){		
		//trees = new Trie[Dim+1];
		for(int i=0;i<Dim;i++){
			trees[i] = new HashMap<String,Map<String,Integer>>();
			if(i != Dim-1){	refTables[i] = new HashMap<String, Integer>();}
		}
		//t(i) indicates search for ith character
		for(int i=0;i<Dim;i++){			
			int wordsSize = wordArray.length;			
			for(int j=0;j<wordsSize;j++){
				//Process with jth word
				if(i == Dim -1){
					Map<String,Integer> Rtb=null;
					String key=wordArray[j].substring(0,wordArray[j].length()-1);
					if(trees[i].containsKey(key) ){
						Rtb = trees[i].get(key);
					}else{
						Rtb = new HashMap<String,Integer>();
					}
					Rtb.put(wordArray[j], 1);
					trees[i].put(key, Rtb);
				}else{
					StringBuilder sb = new StringBuilder(wordArray[j].substring(i+1));
					sb.append(wordArray[j].substring(0, i));
					
					String key = sb.toString();
					sb.append(wordArray[j].charAt(i));	String varvalue = sb.toString();

					Map<String,Integer> Rtb=null;
					if(trees[i].containsKey(key) ){
						Rtb = trees[i].get(key);
					}else{
						Rtb = new HashMap<String,Integer>();
					}
					Rtb.put(varvalue, 1);
					refTables[i].put(varvalue, j);
					trees[i].put(key, Rtb);
				}
			}
		}
	}
    
	public static void main(String[] args) {
		Solution126 s = new Solution126();
		List<String> wList = new ArrayList<String>();
		wList.add("hot");	wList.add("dot");	wList.add("dog");	wList.add("lot");
		wList.add("log");	wList.add("cog");	

/*		wList.add("aa");wList.add("ab");wList.add("ac");wList.add("ad");wList.add("ae");wList.add("ca");
		wList.add("af");wList.add("ag");wList.add("ah");wList.add("ai");wList.add("aj");
		wList.add("ak");wList.add("al");wList.add("am");wList.add("an");wList.add("ao");
		wList.add("ap");wList.add("np");wList.add("sp");wList.add("bb");wList.add("ba");
*/
		System.out.println(s.findLadders("hit", "cog", wList));
	}
	
	
	
	
}
