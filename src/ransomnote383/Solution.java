//86.16%

package ransomnote383;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	public boolean canConstruct(String ransomNote, String magazine) {
		char[] notes=ransomNote.toCharArray();
		char[] mag=magazine.toCharArray();
		for(int i=0;i<notes.length;i++){
			int j=0;
			while(j<mag.length && mag[j] != notes[i]){
				j++;
			}
			if(j >= mag.length){
				return false;
			}else{
				mag[j]= ' ';
			}
		}	
		return true;		
    }

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		boolean result= s.canConstruct("aacb", "aabcdef");
		System.out.println(result);
		
		
	}

}
