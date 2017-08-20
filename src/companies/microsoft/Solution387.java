package companies.microsoft;

public class Solution387 {

	public Solution387() {
		// TODO Auto-generated constructor stub
	}
    public int firstUniqChar(String s) {

    	
// You cannot manage it in only 1 loop.    	
        int [] buckets = new int[26];
        
        char [] str = s.toCharArray();
        
        for(int i=0;i<str.length;i++){
            
            buckets[str[i]-'a'] ++;

        }
        for(int i=0;i<str.length;i++){
            if(buckets[str[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
        
               
    }
}
