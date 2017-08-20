package companies.microsoft;

public class Solution028 {

	public Solution028() {
		// TODO Auto-generated constructor stub
	}
    public int strStr(String haystack, String needle) {
    	//Hardcore
        for(int i=0;i<=haystack.length()-needle.length();i++)
        	if(haystack.substring(i, i+needle.length()).equals(needle))
        		return i;
        return -1;
        //KMP
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
