package compareversions165;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
    public int compareVersion(String version1, String version2) {

    	
    	//1.0.0.0.0.1  1
    	//There are 12 special chars in Java, which couldn't be used as regexp directly.
    	String [] v1=version1.split("\\.");
    	String [] v2=version2.split("\\.");

    	int len1=v1.length;
    	int len2=v2.length;
    	
    	int i=0;
    	while(i<Math.min(len1, len2)){
    		int cmp=Integer.parseInt(v1[i])-Integer.parseInt(v2[i]);
    		if(cmp > 0){
    			return 1;
    		}else if(cmp<0){
    			return -1;
    		}else{
    			i++;
    		}
    	}
    	//These codes cannot pass 1.0.0 & 1.0
/*    	
    	if(len1>len2){
    		return 1;
    	}else if(len1<len2){
    		return -1;
    	}else{
    		return 0;
    	}   	
*/    	    	
    	if(len1>len2){
    		while(i<len1){
    			if(Integer.parseInt(v1[i]) > 0){
    				return 1;
    			}
    			i++;
    		}   		   		
    		return 0;
    	}else if(len1<len2){
    		while(i<len2){
    			if(Integer.parseInt(v2[i]) > 0){
    				return -1;
    			}
    			i++;
    		}       		  		
    		return 0;
    	}else{
    		return 0;
    	}   	
    	

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		System.out.println(s.compareVersion("1.0.0.0.0.1", "1.0.0.0.0.1.0.0"));
		
		
	}

}
