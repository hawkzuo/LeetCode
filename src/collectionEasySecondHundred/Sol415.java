package collectionEasySecondHundred;

/**
 * Created by Amos on 2017/8/28.
 * Add Strings
 */
public class Sol415 {
    // Idea: Bit-by-bit adding
    // append(val) then reverse is a little faster than insert(0,val)
    public String addStrings(String num1, String num2) {

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        StringBuilder res = new StringBuilder();
        int cLen = Math.min(c1.length, c2.length);	int carry = 0;
        for(int i=0;i<cLen;i++){
            int val = (c1[c1.length-1-i]-'0') + (c2[c2.length-1-i]-'0') + carry;
            carry = val / 10;
            // res.insert(0, val % 10);
            res.append(val % 10);
        }

        if (c1.length != c2.length) {
            if(c1.length > c2.length){
                for(int i=c1.length-c2.length-1;i>=0;i--){
                    int val = (c1[i]-'0')+carry;
                    carry = val / 10;
                    // res.insert(0, val % 10);
                    res.append(val % 10);
                }
            }else{
                for(int i=c2.length-c1.length-1;i>=0;i--){
                    int val = (c2[i]-'0')+carry;
                    carry = val / 10;
                    // res.insert(0, val % 10);
                    res.append(val % 10);
                }
            }
        }

        if(carry == 1){
            // res.insert(0, 1);
            res.append(1);
        }
        return res.reverse().toString();
    }


}
