package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Add Binary
 */
public class Sol067 {
    // Idea: Just add up two Strings

    public String addBinary(String a, String b) {
        if(a == null || b== null || a.length() == 0 || b.length() == 0 ){   return "";}

        int m = a.length();     int n = b.length();
        StringBuilder sb = new StringBuilder();

        int commonLen = Math.min(m,n);
        int carry = 0;
        for(int i=0;i<commonLen;i++){
            carry = performAdd(a.charAt(m-1-i)-'0', b.charAt(n-1-i)-'0', carry, sb);
        }

        if (m != n) {
            if(m > n){
                for(int i=commonLen;i<=m-1;i++){
                    carry = performAdd(a.charAt(m-1-i)-'0',  0, carry, sb);
                }
            }else{
                for(int i=commonLen;i<=n-1;i++){
                    carry = performAdd(0, b.charAt(n-1-i)-'0', carry, sb);
                }
            }
        }
        // Final take care
        if(carry != 0){
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    private int performAdd(int left, int right, int carry, StringBuilder sb) {
        int cur = left + right + carry;
        int bit = cur % 2;
        sb.insert(0, bit);
        return cur / 2;
    }
}
