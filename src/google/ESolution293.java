package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/6/17.
 * Flip Game
 */
public class ESolution293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() < 2){ return result;}

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0;i<str.length-1;i++){
            if(str[i] == '+' && str[i+1] == '+'){
                sb.setCharAt(i,'-');
                sb.setCharAt(i+1,'-');
                result.add(sb.toString());
                sb.setCharAt(i,'+');
                sb.setCharAt(i+1,'+');
            }
        }
        return result;
    }
}
