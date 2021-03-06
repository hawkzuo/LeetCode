package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/4.
 * Strobogrammatic Number
 */
public class Sol246 {
    // Idea: Just check the whole path, do not try to check half, otherwise many annoying cases
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length()==0 ){    return true;}
        char[] str = num.toCharArray();
        for(int i=0;i<str.length;i++){
            int valueL = str[i]-'0';
            int valueR = str[str.length-1-i]-'0';
            if (!isRevertable(valueL) || !isRevertable(valueR) || valueL != revert(valueR)) {
                return false;
            }
        }
        return true;
    }
    private boolean isRevertable(int x){
        return x == 0 || x == 1 || x == 6 || x == 8 || x == 9;
    }
    private int revert(int x){
        if(x==6){   return 9;}
        if(x==9){   return 6;}
        return x;
    }
}
