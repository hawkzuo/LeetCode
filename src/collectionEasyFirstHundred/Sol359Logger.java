package collectionEasyFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/9/10.
 * Sol359Logger Rate Limiter
 */
public class Sol359Logger {
    // Idea: TODO: Look into details
    private Map<Integer,Set<String>> table;
    private int startTime;
    private Map<String,Integer> revertible;

    /** Initialize your data structure here. */
    public Sol359Logger() {
        startTime = 0;
        table = new TreeMap<>();
        revertible = new HashMap<>();
    }

    private void update(){
        Iterator<Map.Entry<Integer,Set<String>>>it = table.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Set<String>> pair = it.next();
            if(pair.getKey() < startTime){
                for(String dummy: pair.getValue()){
                    revertible.remove(dummy);
                }
                it.remove();
            }else{
                break;
            }
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int INTERVAL = 10;
        if(timestamp - INTERVAL >= startTime){
            startTime = timestamp - INTERVAL + 1;
            update();
        }

        if(revertible.containsKey(message)){
            return false;
        }else{
            revertible.put(message,timestamp);
            if(!table.containsKey(timestamp)){
                Set<String> dummy = new HashSet<>();
                dummy.add(message);
                table.put(timestamp,dummy);
            }else{
                table.get(timestamp).add(message);
            }
            return true;
        }
    }
}
