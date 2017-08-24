package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/24.
 * Palindrome Number
 */
public class Sol009 {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());
    }
}
