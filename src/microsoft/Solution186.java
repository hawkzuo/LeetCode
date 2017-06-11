//186. Reverse Words in a String II

package microsoft;

public class Solution186 {

	public Solution186() {
		// TODO Auto-generated constructor stub
	}
    public void reverseWords(char[] s) {
    	int len = s.length;
    	
    	rotatechar(s,0,len-1);
    	int bindex = 0;
    	    	
    	for(int i=0;i<len;i++){
    		
    		if(s[i] == ' '){
    			rotatechar(s,bindex,i-1);
    			bindex = i+1;
    			
    		}else{
    			;
    		}
    		
    		
    	}
    	if(bindex >len){
    		;
    	}else{
    		rotatechar(s,bindex,len-1);
    	}
    	
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
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution186 s = new Solution186();
		char [] ch = "the sky is blue".toCharArray();
		s.reverseWords(ch);
		System.out.print(ch);
	}

}
