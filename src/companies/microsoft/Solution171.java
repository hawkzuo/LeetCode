package companies.microsoft;

public class Solution171 {

	public Solution171() {
		// TODO Auto-generated constructor stub
	}

    public int titleToNumber(String s) {
        
    	char[] c=s.toCharArray();
    	int len=c.length;
    	
    	
    	int sum=0;	int factor=1;
    	for(int i=len-1;i>=0;i--){
    		sum+=(c[i]-'A'+1)*factor;
    		factor*=26;    		
    		    		
    	}
    	return sum;
    	
    	
    	
    }	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
