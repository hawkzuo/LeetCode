package companies.microsoft;

public class Solution125 {

	public Solution125() {
		// TODO Auto-generated constructor stub
	}
    public boolean isPalindrome(String s) {
 
    	
//65-90: A-Z
//97-122: a-z
//delta = 32.
    	//Count numbers as well
    	//d+c 2-POINTERS
    	char [] str = s.toCharArray();	
    	
    	int i=0; int j=str.length-1;
    	
    	while(i<j){
    		char c1 = toLowercase(str[i]);
    		while(c1 == 0  && i<=str.length-2){
    			i++;
    			c1 = toLowercase(str[i]);
    		}
    		
    		char c2 = toLowercase(str[j]);
    		while(c2 == 0  && j>=1){
    			j--;
    			c2 = toLowercase(str[j]);
    		}
    		
    		if(c1 == c2){
    			i++;
    			j--;
    		}else{
    			return false;
    		}   		    		
    	}
    	
    	return true;   	
    	
    }
    private char toLowercase(char ch){
    	if(ch >= 65 && ch <= 90){
    		return (char) (ch+'a'-'A');
    		
    	}else if(ch >= 97 && ch <= 122){
    		return ch;
    	}else if(ch >= 48 && ch <= 57){
    		return ch;
    	}else{
    		return 0;
    	}    	   	
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution125 s = new Solution125();
		String str = "0p";
		System.out.print(s.isPalindrome(str));
		
	}

}
