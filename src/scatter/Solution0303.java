package scatter;
import java.util.*;
public class Solution0303 {
    public List<Integer> findSubstring(String s, String[] words) {
        
        //Duplicates are allowed in words.
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || words == null || words[0].length() == 0 || s.length()< words[0].length()*words.length ){ return res;}
        
        //Pre processing words:
        int step = words[0].length();   int totalCount = words.length;
        
        Map<String,Integer> targets = new HashMap<String,Integer>();
        for(String word : words){
            if(targets.containsKey(word)){
                targets.put(word,targets.get(word)+1);
            }else{
                targets.put(word,1);
            }
        }
        Map<String,Deque<Integer>> refer = new HashMap<String,Deque<Integer>>();
        Map<Integer,String> reverseList = new HashMap<Integer,String>();        
        
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i+step<=sb.length();i++){
            String toCheck = sb.substring(i,i+step);
            if(targets.containsKey(toCheck)){
            	Deque<Integer> dummy = null;
                if(refer.containsKey(toCheck)){
                    dummy = refer.get(toCheck);
                }else{
                    dummy = new ArrayDeque<Integer>();
                }
                dummy.offer(i);
                refer.put(toCheck, dummy);
                reverseList.put(i,toCheck);
            }            
        }
        //Try to find the Window
        int maxIndex = -1;
        PriorityQueue<Integer> curWindow = new PriorityQueue<Integer>();
        //Initialize cur window
        for(String ch: targets.keySet()){
            int times = targets.get(ch);
            if(!refer.containsKey(ch)){
                return res;
            }else{
                Deque<Integer> orders = refer.get(ch);
                for(int i=0;i<times;i++){
                    if(orders.isEmpty()){
                        return res;
                    }else{
                        int cIndex = orders.remove();
                        maxIndex = Math.max(maxIndex,cIndex);
                        curWindow.offer(cIndex);
                    }
                }
            }
        }        
        
        int invWinSize = curWindow.size();
        int TargetLength = step * totalCount;
        
        while(curWindow.size() == invWinSize ){
            //First update the global
            int lMost = curWindow.peek();
            if(maxIndex - lMost + step == TargetLength ){
                //Result found
                res.add(lMost);
            }
            //Then try to perform sliding
            String tp = reverseList.get(curWindow.poll());
            Deque<Integer> orders = refer.get(tp);
            
            if(orders.isEmpty()){
                
            }else{
                int nIndex = orders.remove();
                maxIndex = Math.max(maxIndex,nIndex);
                curWindow.offer(nIndex);                
            }
        }        
        
        return res;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ababaab";
		String[] words = {"ab","ba","ba"};
		Solution0303 s = new Solution0303();
		System.out.println(s.findSubstring(input, words));
	} 
}
