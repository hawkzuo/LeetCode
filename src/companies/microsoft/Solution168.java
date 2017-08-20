package companies.microsoft;

public class Solution168 {

	public Solution168() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
    public String convertToTitle(int n) {
        
    	StringBuilder sb=new StringBuilder();
    	char[] ref={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'
    			,'T','U','V','W','X','Y','Z'};
    	
    	while(n / 26 != 0){
    		int key= n % 26;
    		n/=26;  		
    		sb.append(ref[key]);
    		
    		//Key code:
    		if(key == 0){	n--;}
    			
    	}
    	if(n != 0){
    		sb.append(ref[n % 26]);
    	}
    	
    	return sb.reverse().toString();
    	
    	
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution168 s=new Solution168();
		System.out.println(s.convertToTitle(17577));
		
		
	}

}
