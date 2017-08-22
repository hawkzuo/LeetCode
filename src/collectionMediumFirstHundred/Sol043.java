package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/20.
 * Multiply Strings
 */
public class Sol043 {
    public String multiply(String num1, String num2) {

        //TODO: Optimize to constant space
        int m = num1.length();
        int n = num2.length();
        StringBuilder sb = new StringBuilder();

        int leftover = 0;
        int i=0;
        while(i<(m+n)){
            int p1 = 0; int p2 = i-p1;
            int bit =0;
            while(p1 <= Math.min(i, m)){
                if (p1 >= 0 && p1 <= (m-1) && p2 >= 0 && p2 <= (n-1)) {
                    bit +=Character.getNumericValue(num1.charAt(m-1-p1))*Character.getNumericValue(num2.charAt(n-1-p2));
                }
                p1++;	p2--;
            }
            int cur = bit + leftover;
            leftover = cur / 10;
            sb.insert(0,(char)('0'+(cur % 10)));
            i++;
        }
        removeZeros(sb);

        return sb.toString();

    }

    private void removeZeros(StringBuilder src){
        while(src.length() > 0){
            if(src.charAt(0) == '0'){
                src.deleteCharAt(0);

            }else{
                return;
            }
        }
        src.append('0');
    }
}
