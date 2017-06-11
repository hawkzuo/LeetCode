//84.490%
package reversestring344;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	
	public String reverseString(String s){
/*		
		StringBuilder res=new StringBuilder(s);
		int len=res.length();
		for(int i=0;i<len/2;i++){
			char left=res.charAt(i);
			char right=res.charAt(len-i-1);
			res.setCharAt(i, right);
			res.setCharAt(len-i-1, left);
		}				
		return res.toString();
*/
		char[] res=s.toCharArray();
		int len=res.length;
		for(int i=0;i<len/2;i++){
			char temp=res[len-i-1];
			res[len-i-1]=res[i];
			res[i]=temp;
		}
		return new String(res);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String result=s.reverseString("appleeee");
		System.out.println(result);
	}

}
