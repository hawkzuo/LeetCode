package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {

	public Solution253() {
		// TODO Auto-generated constructor stub
	}
	public int minMeetingRooms(Interval[] intervals) {
	       
        if(intervals == null || intervals.length == 0){
            return 0;
        }       
        int total = intervals.length;        
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return Integer.valueOf(o1.start).compareTo(o2.start);
            }
        });
        
        PriorityQueue<Integer> endtimes = new PriorityQueue<Integer>();
        int global =0;
        
        for(int i=0;i<total;i++){
            
            Interval curtask = intervals[i];
            int s=curtask.start;    int e=curtask.end;
            
            if(endtimes.size() == 0){
                global++;
                endtimes.add(e);
            }else{
                int supportearliest = endtimes.peek();
                if(s >= supportearliest){
                    endtimes.poll();
                    endtimes.add(e);
                }else{
                    global++;
                    endtimes.add(e);
                } 
            }         
        }
        return global;
    }
}
