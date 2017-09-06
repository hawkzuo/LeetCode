package collectionEasyFirstHundred;

import collectionUtils.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Amos on 2017/9/6.
 * Meeting Rooms
 */
public class Sol252 {
    // Idea: The writing format of Arrays.sort and the usage of Integer.compare(left, right)
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });

        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return true;
    }
}
