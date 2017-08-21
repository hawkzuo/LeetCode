package collectionMedium;

import java.util.*;
/**
 * Created by Amos on 2017/8/12.
 */
public class ProveKeysetIsOnlyViewOfHashMap {

    public static void main(String[] args) {
//        Sol s = new Sol();

        StringBuilder sb = new StringBuilder();
        for(char ch='a'; ch <= 'z'; ch++) {
            for(int k=0;k<200;k++) {
                sb.append(ch);
            }
        }
        String s = sb.toString();

        HashMap<Character, Integer> freqs = new HashMap<>();
        for(char ch: s.toCharArray()) {
            freqs.put(ch, freqs.getOrDefault(ch, 0) +1);
        }

        ArrayList<Map.Entry<Character, Integer>> arr =
                new ArrayList<Map.Entry<Character, Integer>>();
        for(Character ch: freqs.keySet()) {
            arr.add(new AbstractMap.SimpleEntry<Character, Integer>(ch, freqs.get(ch)));
        }

        PriorityQueue<Map.Entry<Character, Integer>> newQ = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Objects.equals(o2.getValue(), o1.getValue()) ? o2.getKey()-o1.getKey() : o2.getValue()-o1.getValue();
            }
        });
        newQ.addAll(arr);
        while(!newQ.isEmpty()) {
            Map.Entry<Character, Integer> polled = newQ.poll();
            System.out.println(polled.getKey() + "&" + polled.getValue());
        }


//        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return Objects.equals(o2.getValue(), o1.getValue()) ? o2.getKey()-o1.getKey() : o2.getValue()-o1.getValue();
//            }
//        });
//        PriorityQueue<Map.Entry<Character, Integer>> q2 = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return Objects.equals(o2.getValue(), o1.getValue()) ? o2.getKey()-o1.getKey() : o2.getValue()-o1.getValue();
//            }
//        });
//
//        q.addAll(freqs.entrySet());
//
//        while(!q.isEmpty()) {
//            Map.Entry<Character, Integer> polled = q.poll();
//            q2.add(polled);
//        }
//
//        while(!q2.isEmpty()) {
//            Map.Entry<Character, Integer> cur = q2.poll();
//            System.out.println(cur.getKey() + "&" + cur.getValue());
//        }
    }
}
