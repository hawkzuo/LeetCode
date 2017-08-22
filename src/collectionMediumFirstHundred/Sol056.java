package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/23.
 * Merge Intervals
 */
public class Sol056 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }

        int total = intervals.size();
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        Interval curInter = new Interval(-1,-1);
        int rightMost = -1;

        for(int i=0;i<total;i++){
            if(i == 0){
                curInter.start = intervals.get(i).start;
                rightMost = intervals.get(i).end;
            }else{
                if(intervals.get(i).start > rightMost){
                    //Append and Create new
                    curInter.end = rightMost;
                    res.add(curInter);
                    curInter = new Interval(-1,-1);
                    curInter.start = intervals.get(i).start;
                    rightMost = intervals.get(i).end;
                }else{
                    // Combine only
                    rightMost = Math.max(rightMost,intervals.get(i).end);
                }
            }
        }
        curInter.end = rightMost;
        res.add(curInter);
        return res;
    }
}
