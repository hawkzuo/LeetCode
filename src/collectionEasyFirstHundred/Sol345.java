package collectionEasyFirstHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/9/10.
 * Reverse Vowels of a String
 */
public class Sol345 {
    // Idea: Two Pointers Only check for vowels
    //       Can use directly checking instead of Set.contains
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i=0; int j=str.length-1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');   vowels.add('e'); vowels.add('i');    vowels.add('o');    vowels.add('u');
        vowels.add('A');   vowels.add('E'); vowels.add('I');    vowels.add('O');    vowels.add('U');
        while(i < j) {
            if(vowels.contains(str[i])) {
                while(i < j) {
                    if(vowels.contains(str[j])) {
                        // Swap i,j
                        char tmp = str[j];
                        str[j] = str[i];
                        str[i] = tmp;
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return new String(str);
    }

    // Old syntax
    public String reverseVowelsOld(String s) {

        char[] res=s.toCharArray();
        int i=0; int j=res.length-1;
        String vowels="aeiouAEIOU";

        while(i<j){
            while(!contains(vowels,res[i]) && (i<j)){
                i++;
            }
            while(!contains(vowels,res[j]) && (i<j)){
                j--;
            }
            if(i<j){
                char temp=res[j];
                res[j--]=res[i];
                res[i++]=temp;
            }
        }
        return new String(res);
    }
    public static boolean contains(String s, char value){
        return s != null && s.indexOf(value) > -1;
    }
}
