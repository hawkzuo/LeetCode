package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution056 {

	public Solution056() {
		// TODO Auto-generated constructor stub
	}
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        
        int total = intervals.size();
        
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return Integer.valueOf(o1.start).compareTo(o2.start);
            }
        });
        
        
        Interval curInter = new Interval(-1,-1);
        int rmost = -1;
        
        for(int i=0;i<total;i++){
            if(i == 0){
                curInter.start = intervals.get(i).start;
                rmost = intervals.get(i).end;
            }else{
                if(intervals.get(i).start > rmost){
                    //Append and Create new
                    curInter.end = rmost;
                    res.add(curInter);
                    curInter = new Interval(-1,-1);
                    curInter.start = intervals.get(i).start;
                    rmost = intervals.get(i).end;
                }else{
                    // Combine only
                    rmost = Math.max(rmost,intervals.get(i).end);
                }
            }
        }
        curInter.end = rmost;
        res.add(curInter);
        return res; 
    }
}
