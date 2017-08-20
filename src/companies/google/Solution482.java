package companies.google;

/**
 * Created by Amos on 2017/6/10.
 */
public class Solution482 {

    public String licenseKeyFormatting(String S, int K) {

        // Groups of String 1st group must >=1, must not equal to rest groups, rest groups should have same size
        // Idea:    use SB, reverse create the string
        char[] str = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i=str.length-1;i>=0;i--){
            if(str[i] == '-'){  continue;}

            sb.append(Character.toUpperCase(str[i]));
            counter++;

            if(counter == K){
                sb.append('-');
                counter = 0;
            }

        }
        if(sb.length() >=1 && sb.charAt(sb.length()-1) == '-'){    sb.deleteCharAt(sb.length()-1); }
        return sb.reverse().toString();
    }

}
