//151. Reverse Words in a String
package companies.microsoft;

public class Solution151 {

	public Solution151() {
		// TODO Auto-generated constructor stub
	}
/*
	What constitutes a word?
		A sequence of non-space characters constitutes a word.
	Could the input string contain leading or trailing spaces?
		Yes. However, your reversed string should not contain leading or trailing spaces.
	How about multiple spaces between two words?
		Reduce them to a single space in the reversed string.	
*/	

    public String reverseWords(String s) {
    	
    	if(s == null || s.length() == 0){return "";}
        
    	StringBuilder sb = new StringBuilder(s);
    	sb.reverse();
    	
    	//Remove leading/trailing spaces first
    	
    	int i=0; 
    	
    	while(i<sb.length() && sb.charAt(i) == ' '){
    		i++;
    	}
    	sb.delete(0, i);
    	if(sb.length() == 0){return "";}
    	
    	
    	int olen=sb.length();
    	int j=olen-1;
    	while(j>=0 && sb.charAt(j) == ' '){
    		j--;
    	}

    	sb.delete(j+1, olen);    		
    	
    	
    	//Reverse words
    	i=0;
    	char[] chs =sb.toString().toCharArray();
    	StringBuilder sb2 = new StringBuilder();
 
    	
    	
    	
    	
    	int bindex = 0;
    	int len= chs.length;
    	i = 0;
    	while(i<chs.length){
    		
    		if(chs[i] == ' '){
    			rotatechar(chs,bindex,i-1);
    			sb2.append(chs, bindex, i-bindex+1);
    			i++;
    			while(i<chs.length && chs[i] == ' '){
    				i++;
    			}    			
    			bindex = i;    			
    		}else{
    			i++;
    		}    		
    		
    	}
    	
    	if(bindex >len){
    		;
    	}else{
    		rotatechar(chs,bindex,len-1);
    		sb2.append(chs,bindex,len-bindex);
    	}    	
    	
    	
    	return sb2.toString();
    }	
    private void rotatechar(char[] chs, int begin, int end){
    	
    	int i=begin; int j=end;
    	if(j <= i){	return;}
    	
    	while(i<(end+begin+1)/2){
    		char t = chs[i];
    		chs[i]=chs[j];
    		chs[j]=t;
    		i++;	j--;    		
    	}    	    	
    }	
    public String reverseWords2(String s){
    	if(s == null || s.length() == 0){return "";}
        
    	StringBuilder sb = new StringBuilder(s);
    	sb.reverse();
    	
    	//Remove leading/trailing spaces first
    	
    	int i=0; 
    	
    	while(i<sb.length() && sb.charAt(i) == ' '){
    		i++;
    	}
    	sb.delete(0, i);
    	if(sb.length() == 0){return "";}
    	
    	
    	int olen=sb.length();
    	int j=olen-1;
    	while(j>=0 && sb.charAt(j) == ' '){
    		j--;
    	}

    	sb.delete(j+1, olen);   	
    	
    	//Reverse words
    	
    	return "";
    	
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution151 s = new Solution151();
		String str = " kkk";
		String n = s.reverseWords(str);
		System.out.print(n);
	}

}
