package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * Convert a Number to Hexadecimal
 */
public class Sol405 {
    // Idea: One Hex bit = 4bits, one-by-one generate
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        char[] str = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        for(int j=1;j<=8;j++){
            int bit = (num >> (32-j*4)) & 15;
            if(sb.length() == 0){
                if (bit != 0) {
                    sb.append(str[bit]);
                }
            }else{
                sb.append(str[bit]);
            }
        }
        if(sb.length() == 0){
            sb.append('0');
        }
        return sb.toString();
    }
}
