package collectionMedium;

/**
 * Created by Amos on 2017/8/10.
 * One Edit Distance
 */
public class Sol161 {
    public boolean isOneEditDistance(String s, String t) {
        // Brute-force checking 3 situations for One-Edit-Distance

        if(s == null || t == null){ return false;}

        int l1=s.length();  int l2=t.length();
        if(l1 == l2 && l1 == 0){    return false;}
        if(l1 == l2){
            int count=0;
            for(int i=0;i<l1;i++){
                if(s.charAt(i) != t.charAt(i)){
                    count++;
                }
            }
            return count == 1;
        }else if (l1-l2 == 1){
            //l1: xapple/axpple/apxple/appxle/applxe/applex
            //l2: apple
            int diffindex = -1;
            for(int i=0;i<l2;i++){
                if(s.charAt(i) != t.charAt(i)){
                    diffindex = i;
                    break;
                }
            }
            if(diffindex == -1){    return true;}

            int i=diffindex;
            while(i<l2){
                if(s.charAt(i+1) != t.charAt(i)){
                    return false;
                }
                i++;
            }
            return true;
        }else if(l2-l1 == 1){
            int diffindex = -1;
            for(int i=0;i<l1;i++){
                if(s.charAt(i) != t.charAt(i)){
                    diffindex = i;
                    break;
                }
            }

            if(diffindex == -1){    return true;}

            int i=diffindex;
            while(i<l1){
                if(s.charAt(i) != t.charAt(i+1)){
                    return false;
                }
                i++;
            }
            return true;
        }else{
            return false;
        }
    }
}
