package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/27.
 * Restore IP Addresses
 */
public class Sol093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) {    return result;}
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        generateAns(sb, 0, 0, str, result);
        return result;
    }
    private void generateAns(StringBuilder currentAddress, int formedCount, int pos, char[] s, List<String> result) {
        // 111.111.111.1111
        // 012 345 678 9101112....
        // Base
        if(formedCount == 3) {
            if (s.length <= pos + 2 + 1) {
                if(s.length == pos + 1){
                    currentAddress.append(s[pos]);
                    result.add(currentAddress.toString());
                    currentAddress.deleteCharAt(currentAddress.length()-1);
                }else if(s.length == pos + 2){
                    if(isValidTwoDigit(s[pos],s[pos+1])){
                        currentAddress.append(s[pos]);currentAddress.append(s[pos+1]);
                        result.add(currentAddress.toString());
                        currentAddress.delete(currentAddress.length()-2,currentAddress.length());
                    }
                }else if(s.length == pos + 3){
                    if(isValidThreeDigit(s[pos], s[pos+1], s[pos+2])){
                        currentAddress.append(s[pos]);currentAddress.append(s[pos+1]);currentAddress.append(s[pos+2]);
                        result.add(currentAddress.toString());
                        currentAddress.delete(currentAddress.length()-3,currentAddress.length());
                    }
                }
            }
        }

        if(pos + 2 < s.length && isValidThreeDigit(s[pos], s[pos+1], s[pos+2])) {
            currentAddress.append(s[pos]);currentAddress.append(s[pos+1]);currentAddress.append(s[pos+2]);currentAddress.append(".");
            generateAns(currentAddress, formedCount+1, pos+3, s, result);
            currentAddress.delete(currentAddress.length()-4,currentAddress.length());
        }
        if(pos + 1 < s.length && isValidTwoDigit(s[pos], s[pos+1])) {
            currentAddress.append(s[pos]);currentAddress.append(s[pos+1]);currentAddress.append(".");
            generateAns(currentAddress, formedCount+1, pos+2, s, result);
            currentAddress.delete(currentAddress.length()-3,currentAddress.length());
        }
        if(pos < s.length) {
            currentAddress.append(s[pos]);currentAddress.append(".");
            generateAns(currentAddress, formedCount+1, pos+1, s, result);
            currentAddress.delete(currentAddress.length()-2,currentAddress.length());
        }
    }

    private boolean isValidThreeDigit(char c, char c1, char c2) {
        int h3 = c-'0';
        int h2 = c1-'0';
        int h1 = c2-'0';
        if(h3 == 2){
            if(h2 == 5){
                return h1 >=0 && h1 <=5;
            }else{
                return h2 >=0 && h2 <=4 && h1>=0 && h1<=9;
            }
        }else{
            return h3>0 && h3<=1 && h2>=0 && h2<=9 && h1>=0 && h1<=9;
        }
    }

    private boolean isValidTwoDigit(char c, char c1) {
        int high = c-'0';
        int low = c1-'0';
        return high > 0 && high <= 9 && low >= 0 && low <= 9;
    }
    public static void main(String[] args) {
        Sol093 s = new Sol093();
        List<String> strings = s.restoreIpAddresses("22222212");
        System.out.println();
    }

}
