package google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/6/11.
 */
public class ESolution346_MovingAverage {
    Deque<Integer> q;
    int maxLength;
    int curLength = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public ESolution346_MovingAverage(int size) {
        q = new ArrayDeque<Integer>();
        maxLength = size;
    }

    public double next(int val) {
        double res = 0;
        if(maxLength == 0){ return res;}
        if(curLength < maxLength){
            sum += val;
            q.addLast(val);
            curLength ++;
        }else{
            int toRemove = q.removeFirst();
            sum -= toRemove;
            sum += val;
            q.addLast(val);
        }
        res = (double)sum / curLength;
        return res;
    }
}
