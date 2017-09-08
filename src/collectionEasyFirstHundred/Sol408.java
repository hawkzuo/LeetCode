package collectionEasyFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/9/10.
 * Valid Word Abbreviation
 */
public class Sol408 {
    // Idea: First Idea is brute-force matching, but realize List might help.
    //      Turned out List cannot help. Move back to Brute-force matching
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length() == 0) {
            return word.length() == 0;
        }
        char[] str = word.toCharArray();
        char[] ref = abbr.toCharArray();
        int strIndex = 0;
        int refIndex = 0;

        while(strIndex < str.length && refIndex < ref.length) {
            // Scan the ref char by char, if encounter number, read the number and keep matching
            char step = ref[refIndex];
            if(step - '0' >= 0 && step -'0' <= 9) {
                if(step - '0' == 0) {
                    return false;
                }
                // Read Int
                int sum = step - '0';
                refIndex ++;
                while(refIndex < ref.length) {
                    char next = ref[refIndex];
                    if(next - '0' >= 0 && next -'0' <= 9) {
                        sum = sum * 10 + next -'0';
                    } else {
                        break;
                    }
                    refIndex ++;
                }
                // Match int count in given string
                strIndex += sum;
            } else {
                // Pure character case, check for corresponding char and move to next char
                if(str[strIndex] != step) {
                    return false;
                }
                strIndex ++;
                refIndex ++;
            }
        }
        // Only two strings end at the same time will the matching be accurate, so:
        return refIndex == ref.length && strIndex == str.length;
    }


    // This method can solve this problem theoretically, but I don't want to try anymore
    public boolean validWordAbbreviationAbandoned(String word, String abbr) {
        char[] ref = abbr.toCharArray();
        // Split the abbr first
        List<String> chars = new ArrayList<>();
        List<Integer> shorts = new ArrayList<>();

        int index = 0;
        int counter = 0;    StringBuilder sb = new StringBuilder();
        boolean isDigit = false;
        while(index < ref.length) {
            int offset = ref[index] - '0';
            if(offset >= 0 && offset <= 9) {
                // Is digit
                if(index != 0 && !isDigit) {
                    // We need to add the string to container
                    chars.add(sb.toString());
                    sb.setLength(0);
                }
                // Leading zeros are regarded wrong answer ****
                if(counter == 0 && offset == 0) {
                    return false;
                }
                counter = counter * 10 + offset;
                isDigit = true;
            } else {
                if(index != 0 && isDigit) {
                    // We need to add the number to container
                    shorts.add(counter);
                    counter = 0;
                }
                sb.append(ref[index]);
                isDigit = false;
            }
            index ++;
        }
        if(!isDigit && sb.length() > 0) {
            chars.add(sb.toString());
        }
        if(isDigit && counter > 0) {
            shorts.add(counter);
        }



        int rIndex = 0;
        int sIndex = 0;
        while(rIndex < Math.min(chars.size(), shorts.size()) && sIndex < word.length()) {
            String toCompare = chars.get(rIndex);
            if(sIndex + toCompare.length() > word.length() || !toCompare.equals(word.substring(sIndex, sIndex + toCompare.length()))) {
                return false;
            }
            sIndex += toCompare.length();
            Integer omitCount = shorts.get(rIndex);
            sIndex += omitCount;
            rIndex ++;
        }

        if(chars.size() > rIndex) {
            // Left a char
            String toCompare = chars.get(rIndex);
            if(sIndex + toCompare.length() > word.length() || !toCompare.equals(word.substring(sIndex, sIndex + toCompare.length()))) {
                return false;
            }
            sIndex += toCompare.length();
        } else if(shorts.size() > rIndex) {
            Integer omitCount = shorts.get(rIndex);
            sIndex += omitCount;
        }
        return sIndex == word.length();

    }

    public static void main(String[] args) {
        // Some test cases:
        //  "internationalization"
        //  "i12iz04n"
        //  "internationalization"
        //  "i11l1z1tion"
        //  "internationalization"
        //  "i11l1z13"
        //  "a"
        //  "01"
        //  "a"
        //  "1"
        //  "internationalization"
        //  "i12iz4n0"
        //  "internationalization"
        //  "i12iz3o01"
        //  "hi"
        //  "1i"
        Sol408 s = new Sol408();
        int[] A = {};
        int[] B = {};

        StringBuilder sb = new StringBuilder();
        System.out.println(s.validWordAbbreviation("hi",
                "1i"));
    }

}
