package collectionACompanies.google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Decode String
 * Created by Amos on 2017/6/11.
 */
public class Solution394 {
/*
    First Trial:    Try to use reverse order, but failed, hard to distinguish the order
    Second Trail:   Try to separate the counts and the strings. Use the invariant: always keep the top of the stack
    to be a String value instead of special character '[', which represents the deepest inner scope of the parsing phase.
    Then if normal char, update the top String, if isDigit, stop adding and parse the Number, if '[', push 2(instead of 1)
    strings into stack, if ']', push out times and top String, repeated and reduce the scope by 1.
    Final result will be stack.pop()
     */
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<String>();
        Deque<Integer> counts = new ArrayDeque<Integer>();
        stack.push("");

        char[] str = s.toCharArray();

        int i=0;
        while(i<str.length){
            char step = str[i];
            if(!isDigit(step) && step != '[' && step != ']'){
                stack.push(stack.pop()+step);
                i++;
            }else if(isDigit(step)){
                StringBuilder sb = new StringBuilder();
                sb.append(step);
                i++;
                while(i<str.length){
                    if(isDigit(str[i])){
                        sb.append(str[i]);  i++;
                    }else{  break;  }
                }
                counts.push(Integer.valueOf(sb.toString()));
            }else if(step == '['){
                stack.push("[");    stack.push("");     i++;
            }else{
                int repeatTimes = counts.pop();
                String toBeRepeated = stack.pop();  stack.pop();
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<repeatTimes;j++){
                    sb.append(toBeRepeated);
                }
                stack.push(stack.pop()+sb.toString());
                i++;
            }
        }

        return stack.pop();

    }

    private boolean isDigit(char ch){
        if( (ch - '0') >=0 && (ch - '9' <= 0) ){    return true;    }
        else{   return false;}
    }

    public static void  main(String[] args){
        Solution394 s = new Solution394();
        System.out.print(s.decodeString("4[b3[c2[d]e2[bc]]fk]s"));
    }
}
