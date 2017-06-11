package scatter;
import java.util.*;
public class Solution076 {
    public String minWindow(String s, String t) {
        if(s == null || t == null){ return "";}
        else if(s.length() < t.length() ){  return "";}

        //Pre processing
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Map<Character,Integer> targets = new HashMap<Character,Integer>();
        Map<Character,Deque<Integer>> refer = new HashMap<Character,Deque<Integer>>();
        
        Map<Integer,Character> reverseList = new HashMap<Integer,Character>();
        for(int i=0;i<ct.length;i++){
            if(targets.containsKey(ct[i])){
                targets.put(ct[i],targets.get(ct[i])+1);
            }else{
                targets.put(ct[i],1);
            }
        }
        for(int i=0;i<cs.length;i++){
            if(targets.containsKey(cs[i])){
            	Deque<Integer> dummy = null;
                if(refer.containsKey(cs[i])){
                    dummy = refer.get(cs[i]);
                }else{
                    dummy = new ArrayDeque<Integer>();
                }
                dummy.offer(i);
                refer.put(cs[i], dummy);
                reverseList.put(i,cs[i]);
            }
        }
        int minLength = Integer.MAX_VALUE;
        int minLeft = -1;   int minRight = -1;  int maxIndex = -1;
        PriorityQueue<Integer> curWindow = new PriorityQueue<Integer>();
        //Initialize cur window
        for(Character ch: targets.keySet()){
            int times = targets.get(ch);
            if(!refer.containsKey(ch)){
                return "";
            }else{
                Deque<Integer> orders = refer.get(ch);
                for(int i=0;i<times;i++){
                    if(orders.isEmpty()){
                        return "";
                    }else{
                        int cIndex = orders.remove();
                        maxIndex = Math.max(maxIndex,cIndex);
                        curWindow.offer(cIndex);
                    }
                }
            }
        }
        
        int invWinSize = curWindow.size();
        
        while(curWindow.size() == invWinSize ){
            //First update the global
            int lMost = curWindow.peek();
            if(maxIndex - lMost < minLength ){
                minLength = maxIndex - lMost;
                minLeft = lMost;
                minRight = maxIndex;
            }
            //Then try to perform sliding
            Character tp = reverseList.get(curWindow.poll());
            Deque<Integer> orders = refer.get(tp);
            
            if(orders.isEmpty()){
                
            }else{
                int nIndex = orders.remove();
                maxIndex = Math.max(maxIndex,nIndex);
                curWindow.offer(nIndex);                
            }
        }
        
        if(minLeft == -1){  return "";}
        else{
            return s.substring(minLeft,minRight+1);
        }

    }
    public static void main(String[] args) {
    	Solution076 s = new Solution076();
    	System.out.println(s.minWindow("aefddadad", "adf"));
    }
}
