package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/6/15.
 */
public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0 ){    return res;}
        if(n == 1){ res.add("0");   res.add("1");   res.add("8");   return res;}
        // {1 6 8 9} first-digit
        // {0 1 8} midRemain
        // {0 1 6 8 9} others
        boolean odd = (n % 2 != 0);
        for(int i=0;i<n/2;i++){
            if(i==0){
                res.add("1");   res.add("6");   res.add("8");   res.add("9");
            }else{
                List<String> newRes = new ArrayList<>();
                for(String str: res){
                    newRes.add(str+"0");newRes.add(str+"1");
                    newRes.add(str+"6");newRes.add(str+"8");newRes.add(str+"9");
                }
                res = newRes;
            }
        }
        if(odd){
            List<String> newRes = new ArrayList<>();
            for(String str: res){
                newRes.add(str+"0");newRes.add(str+"1");newRes.add(str+"8");
            }
            res = newRes;
        }
        return postProcess(res,odd);
    }
    private List<String> postProcess(List<String> input, boolean odd){
        List<String> result = new ArrayList<>();
        int offset = 0;
        if(odd){    offset = 1;}
        for(String str: input){
            char[] s = str.toCharArray();
            StringBuilder sb = new StringBuilder(str);
            for(int i=s.length-1-offset;i>=0;i--){
                sb.append(revert(s[i]));
            }
            result.add(sb.toString());
        }
        return result;
    }
    private char revert(char x){
        if(x=='6'){   return '9';}
        if(x=='9'){   return '6';}
        return x;
    }
}
