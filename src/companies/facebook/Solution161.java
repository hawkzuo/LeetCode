package companies.facebook;

public class Solution161 {

	public Solution161() {
		// TODO Auto-generated constructor stub
	}
    public boolean isOneEditDistance(String s, String t) {
        
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
            if(count == 1){ return true;}
            else{   return false;}
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
