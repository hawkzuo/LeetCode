//72.02%


package reversevowels345;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public String reverseVowels(String s) {
       
		char[] res=s.toCharArray();
		int i=0; int j=res.length-1;
		String vowels="aeiouAEIOU";
		
		while(i<j){
			//Do not forget the i<j bound
			while(!contains(vowels,res[i]) && (i<j)){
				i++;
			}
			while(!contains(vowels,res[j]) && (i<j)){
				j--;
			}
			if(i<j){
				char temp=res[j];
				res[j--]=res[i];
				res[i++]=temp;								
			}
		}				
		return new String(res);
    }
	public static boolean contains(String s, char value){
	    return s != null && s.indexOf(value) > -1;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		String result=s.reverseVowels(".,");
		System.out.println(result);
		
		
	}

}
