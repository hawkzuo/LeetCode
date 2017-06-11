package scatter;
import java.util.*;
public class Solution332 {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0){
            res.add("JFK");
            return res;
        }
        if(tickets.length == 1){
            res.add(tickets[0][0]); res.add(tickets[0][1]);
            return res;
        }
        
        Arrays.sort(tickets,new Comparator<String[]>(){
			@Override
			public int compare(String[] arg0, String[] arg1) {
				// TODO Auto-generated method stub
				char[] c1 = arg0[1].toCharArray();
				char[] c2 = arg1[1].toCharArray();
				if(Character.valueOf(c1[0]).compareTo(c2[0]) != 0){
				    return Character.valueOf(c1[0]).compareTo(c2[0]);
				}else if(Character.valueOf(c1[1]).compareTo(c2[1]) != 0){
				    return Character.valueOf(c1[1]).compareTo(c2[1]);
				}else{
				    return Character.valueOf(c1[2]).compareTo(c2[2]);
				}
			}            
        });

        Map<String,Deque<String>> table = new HashMap<String,Deque<String>>();
        for(int i=0;i<tickets.length;i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            if(!table.containsKey(from)){
                Deque<String> queue = new LinkedList<String>();
                queue.offer(to);
                table.put(from,queue);
            }else{
                Deque<String> queue = table.get(from);
                queue.offer(to);
            }
        }
        //Must use Euler Tour Algorithm
        int i=0;
        String cur = "JFK";
        Deque<String> adj = table.get(cur);
        res.add(cur);
        while(i<tickets.length){
            cur = adj.remove();
            if(i == tickets.length -1){
            	res.add(cur);	break;
            }
            Deque<String> stack = new ArrayDeque<String>();
            while(!table.containsKey(cur)){
            	stack.push(cur);
            	cur = adj.remove();
            }            
            for(int dm = 0;dm<stack.size();dm++){
            	adj.addFirst(stack.pop());
            }            
            res.add(cur);
            adj = table.get(cur);
            i++;
        }
        
        return res;

    }
    
    public static void main(String[] args) {
    	String[][] tcks = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},
    			{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},
    			{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
    	Solution332 s = new Solution332();
    	System.out.println(s.findItinerary(tcks));
    }
    
    
    
}
