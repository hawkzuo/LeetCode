package collectionEasyFirstHundred;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/9/10.
 * Moving Average from Data Stream
 */
public class Sol346MovingAverage {
    // Idea: Simple and basic Sliding Window    -- No restrains on this window property

    private Deque<Integer> window;
    private int maxLength;
    private int curLength = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public Sol346MovingAverage(int size) {
        window = new ArrayDeque<>();
        maxLength = size;
    }

    public double next(int val) {
        double res = 0;
        if(maxLength == 0){ return res;}
        if(curLength < maxLength){
            sum += val;
            window.addLast(val);
            curLength ++;
        }else{
            int toRemove = window.removeFirst();
            sum -= toRemove;
            sum += val;
            window.addLast(val);
        }
        res = (double)sum / curLength;
        return res;
    }
}
