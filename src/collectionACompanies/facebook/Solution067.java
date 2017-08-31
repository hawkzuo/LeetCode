package collectionACompanies.facebook;

public class Solution067 {

	public Solution067() {
		// TODO Auto-generated constructor stub
	}
    public String addBinary(String a, String b) {
        if(a == null || b== null || a.length() == 0 || b.length() == 0 ){   return "";}
        
        int m = a.length();     int n = b.length();
        StringBuilder sb = new StringBuilder();
        
        int com = Math.min(m,n);    
        int carry = 0;
        for(int i=0;i<com;i++){
            int cur = (a.charAt(m-1-i)-'0') + (b.charAt(n-1-i)-'0') + carry;
            int bit = cur % 2;  
            carry = cur / 2;
            sb.insert(0, bit);
        }

        if(m == n){
        	;
        }else if(m > n){
            for(int i=com;i<=m-1;i++){
                int cur = (a.charAt(m-1-i)-'0') + carry;
                int bit = cur % 2;  
                carry = cur / 2;
                sb.insert(0, bit);
            }
        }else{
            for(int i=com;i<=n-1;i++){
                int cur = (b.charAt(n-1-i)-'0') + carry;
                int bit = cur % 2;  
                carry = cur / 2;
                sb.insert(0, bit);
            }          
        }        
        if(carry != 0){
        	sb.insert(0, 1);
        }        
        return sb.toString();
        
        
    }
    
    public static void main(String[] args) {
    	Solution067 s = new Solution067();
    	System.out.println(s.addBinary("1111", "1111111"));
    	
    }
    
    
    
}
