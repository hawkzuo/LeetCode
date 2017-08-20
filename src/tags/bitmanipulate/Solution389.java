//389. Find the Difference
//461 371 003
package tags.bitmanipulate;

public class Solution389 {

	public Solution389() {
		// TODO Auto-generated constructor stub
	}

    public char findTheDifference(String s, String t) {
        
    	char[] sc =s.toCharArray();
    	char[] tc =t.toCharArray();
    	
    	int res = 0;
    	
    	for(int i=0;i<sc.length;i++){
    		res ^= sc[i];
    	}
    	for(int j=0;j<tc.length;j++){
    		res ^= tc[j];
    	}
    	return (char)res;
    	
    }	

	public static void main(String[] args) {
		
		String s1="abcd";
		String t="abcde";
		Solution389 s=new Solution389();
		char res = s.findTheDifference(s1, t);
		System.out.print(res);
		
	}   
    
    
    
}
