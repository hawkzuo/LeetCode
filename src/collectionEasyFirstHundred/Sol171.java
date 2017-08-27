package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Excel Sheet Column Number
 */
public class Sol171 {
    // Idea: Reverse process of Sol168
    // Just Brute-force adding numbers
    public int titleToNumber(String s) {
        char[] c=s.toCharArray();
        int len=c.length;

        int sum=0;	int factor=1;
        for(int i=len-1;i>=0;i--){
            sum+=(c[i]-'A'+1)*factor;
            factor*=26;
        }
        return sum;
    }
}
