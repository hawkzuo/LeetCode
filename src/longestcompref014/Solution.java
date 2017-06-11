//84.28%

package longestcompref014;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
    public String longestCommonPrefix(String[] strs) {
      
    	if(strs == null || strs.length==0){return "";}
    	if(strs.length == 1){return strs[0];}
    	
    	int num=strs.length;
    	
    	char [][]	arrays=new char[num][];
    	
    	int minimalLength=Integer.MAX_VALUE;
    	
    	for(int i=0;i<num;i++){
    		if(strs[i] == null || strs[i].length()==0){return "";}   		    		
    		arrays[i]=strs[i].toCharArray();
    		if(arrays[i].length<minimalLength){
    			minimalLength=arrays[i].length;
    		}
    	}
    	
    	StringBuilder sb=new StringBuilder();
    	mainloop:
    	for(int j=0;j<minimalLength;j++){
    		int k=0;
    		char value=arrays[k][j];
    		while(k<num){
    			if(value != arrays[k][j]){
    				break mainloop;
    			}else{
    				k++;
    			}
    		}
    		sb.append(value);
    	}    	
    	if(sb.length() == 0){return "";}
       	return sb.toString();
    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String [] strs={"fec","aaabc","aaacb"};
		System.out.println(s.longestCommonPrefix(strs));
		
		
	}

}
