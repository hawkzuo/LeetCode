package collectionACompanies.microsoft;

public class Solution013 {

	public Solution013() {
		// TODO Auto-generated constructor stub
	}
    public int romanToInt(String s) {        
    	char [] str = s.toCharArray();
 
    	int prev = 0;
    	int sum = 0;
    	
    	for(int i=0;i<str.length;i++){
    		int now = convertBit(str[i]);
    		
    		if(prev < now){
    			
    			sum = sum + now - 2*prev;
    			
    		}else{
    			//<=
    			sum += now;
    			
    		}
    		
    		prev = now;
    	}
    	return sum;
    	
    }
    private int convertBit(char ch){
    	
    	if(ch >= 'a' && ch <= 'z'){
    		ch -= 32;
    	}
    	    	
    	switch(ch){
    	
    	case 'I': return 1;
    	case 'V': return 5;
    	case 'X': return 10;
    	case 'L': return 50;
    	case 'C': return 100;
    	case 'D': return 500;
    	case 'M': return 1000;
    	default: return -1;   	
    	}
    	   	
    	
    }
    
    
    
    
    
	public static void main(String[] args) {
		
	}
    
    
}
