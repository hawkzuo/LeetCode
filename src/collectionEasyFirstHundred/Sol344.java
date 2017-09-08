package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Reverse String
 */
public class Sol344 {
    // Idea: Swap two chars at one time until reach middle of the string
    public String reverseString(String s) {
        char[] res=s.toCharArray();
        int len=res.length;
        for(int i=0;i<len/2;i++){
            char temp = res[len-i-1];
            res[len-i-1]=res[i];
            res[i]=temp;
        }
        return new String(res);
    }
}
