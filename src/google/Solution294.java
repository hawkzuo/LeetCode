package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amos on 2017/6/17.
 * Flip Game II
 */
public class Solution294 {
    Map<String,Integer> table;
    public boolean canWin(String s) {
        table = new HashMap<>();
        return helper(s) > 0;
    }

    private int helper(String input){
        if(table.containsKey(input)){   return table.get(input);    }
        int canWin = 0;
        char[] str = input.toCharArray();
        StringBuilder sb = new StringBuilder(input);

        for(int i=0; i< str.length-1;i++){
            if(str[i] == '+' && str[i+1] == '+'){
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                if(helper(sb.toString()) > 0){
                    canWin = 0;
                }else{  canWin = 1;}
                sb.setCharAt(i,'+');
                sb.setCharAt(i+1,'+');
                if(canWin > 0){ break;}
            }
        }
        //Memorized
        table.put(input,canWin);
        return canWin;
    }
    public static void main(String[] args){
        Solution294 s = new Solution294();
        System.out.println(s.canWin("++++++++++"));
    }
}
