package unclassified;

/**
 * Created by Amos on 2017/8/30.
 *
 */
public class Sol567Fast {
    public boolean checkInclusion(String s1, String s2) {

        //判断s1,s2长度
        if(s1.length() > s2.length()){
            return false;
        }

        int [] map1 = new int [26];
        int [] map2 = new int [26];
        int len1 = s1.length();
        int len2 = s2.length();
//         能进行这样的操作前提是s2比s1长
        for(int i = 0; i < len1; i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
//         i is the current start of str2
        // a b c d
        // a b
        for(int i = 0; i < len2 - len1; i++){
            if(match(map1,map2)){
                return true;
            }
            map2[s2.charAt(i + len1) - 'a']++;
            map2[s2.charAt(i) - 'a']--;
        }
        return match(map1, map2);
    }

    // Brute-force checking 26 chars
    private boolean match(int [] map1, int[] map2){
        for(int i = 0; i < map1.length; i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }
}
