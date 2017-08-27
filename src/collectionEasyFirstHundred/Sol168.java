package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Excel Sheet Column Title
 */
public class Sol168 {
    // Idea: Mind the difference between this and 16 digits rule    <- This is easier
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        char[] ref={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'
                ,'T','U','V','W','X','Y','Z'};
        // 1 -> A       26 -> Z     27 -> AA    28-> AB
        while(n / 26 != 0){
            int key= n % 26;
            n/=26;
            sb.append(ref[key]);
            //Key code for letting ref[0] to be 'Z' (26)
            if(key == 0){	n--;}
        }
        // Final take care
        if(n != 0){
            sb.append(ref[n % 26]);
        }
        return sb.reverse().toString();
    }
}
