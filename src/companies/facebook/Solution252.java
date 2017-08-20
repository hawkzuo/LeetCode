package companies.facebook;

import java.util.Arrays;
import java.util.Comparator;

public class Solution252 {

	public Solution252() {
		// TODO Auto-generated constructor stub
	}
	public boolean canAttendMeetings(Interval[] intervals) {
        
        if(intervals == null || intervals.length == 0){
            return true;
        }
        
        int endTime = -1;
        
        // Has to sort, otherwise hard to determine intervals
        int total = intervals.length;
        
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return Integer.valueOf(o1.start).compareTo(o2.start);
            }
        });
        
        for(int i=0;i<total;i++){
            if(intervals[i].start >= endTime){
                endTime = intervals[i].end;
            }else{
                return false;
            }
        }
        return true;
    }
}
