package google;

/**
 * Created by Amos on 2017/6/18.
 * Repeated Substring Pattern
 * Just Brute-Force, try all the possible combinations for the repeat times.
 * Boring
 */
public class ESolution459 {
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
