package collectionMediumSecondHundred;

import java.util.*;

/**
 * Created by Amos on 2017/9/8.
 * Unique Word Abbreviation
 */
public class Sol288ValidWordAbbr {

    // Idea: Junk kind problems

    private Map<String, Integer> frequency;
    private Set<String> oneTimeSeeds;

    public Sol288ValidWordAbbr(String[] dictionary) {
        frequency = new HashMap<>();

        Set<String> removed = new HashSet<>();
        removed.addAll(Arrays.asList(dictionary));

        oneTimeSeeds = new HashSet<>();

        for(String dm: removed) {
            String abbr = trim(dm);
            if(frequency.containsKey(abbr)) {
                frequency.put(abbr, frequency.get(abbr) + 1);
                oneTimeSeeds.remove(dm);
            } else {
                frequency.put(abbr, 1);
                oneTimeSeeds.add(dm);
            }
        }
    }

    private String trim(String input) {
        if(input.length() <= 1) {   return input; }
        return String.valueOf(input.charAt(0)) + (input.length() - 2) + input.charAt(input.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbr = trim(word);
        if(!frequency.containsKey(abbr)) {
            return true;
        } else {
            //
            int times = frequency.get(abbr);
            return times == 1 && oneTimeSeeds.contains(word);
        }
    }
}
