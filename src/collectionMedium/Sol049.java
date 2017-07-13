package collectionMedium;

import java.util.*;

/**
 * Created by Amos on 2017/7/20.
 * Group Anagrams
 */
public class Sol049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();
        //loop takes O(n) time
        for(String str : strs){
            //key takes O(mlogm) time
            char [] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            if(!m.containsKey(key)){
                List<String> newInstance = new LinkedList<>();
                newInstance.add(str);
                m.put(key, newInstance);
            }else{
                List<String> fetchedInstance = m.get(key);
                fetchedInstance.add(str);
            }
        }
        return new LinkedList<>(m.values());
    }
}
